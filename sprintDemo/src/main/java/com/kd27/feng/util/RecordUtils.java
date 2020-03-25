package com.kd27.feng.util;


import org.bytedeco.javacv.*;

import java.io.File;

public class RecordUtils {

    /**
     * 收流器
     * @param inputFile
     * @param outputFile
     * @param audioChannel
     * @throws Exception
     * @throws FrameRecorder.Exception
     */
    public static void frameRecord(String inputFile, String outputFile, int audioChannel,Boolean isRecord)
            throws Exception, FrameRecorder.Exception {

        boolean isStart=isRecord;//该变量建议设置为全局控制变量，用于控制录制结束
        // 获取视频源
        FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(inputFile);
        // 流媒体输出地址，分辨率（长，高），是否录制音频（0:不录制/1:录制）
        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(outputFile, 1280, 720, audioChannel);
        // 开始取视频源
        recordByFrame(grabber, recorder, isStart);
    }

    //录制
    private static void recordByFrame(FFmpegFrameGrabber grabber, FFmpegFrameRecorder recorder, Boolean status)
            throws Exception, FrameRecorder.Exception {
        try {
            grabber.start();
            recorder.start();
            Frame frame = null;
            while (status&& (frame = grabber.grabFrame()) != null) {
                recorder.record(frame);
            }
            recorder.stop();
            grabber.stop();
        } finally {
            if (grabber != null) {
                System.out.println("录制结束");
                grabber.stop();
            }
        }
    }


    //获取时间
    public static long getVideoDuration(File video) {
        long duration = 0L;
        FFmpegFrameGrabber ff = new FFmpegFrameGrabber(video);
        try {
            ff.start();
            duration = ff.getLengthInTime() / (1000 * 1000);
            ff.stop();
        } catch (FrameGrabber.Exception e) {
            e.printStackTrace();
        }
        return duration;
    }




    public static void main(String[] args)
            throws FrameRecorder.Exception, FrameGrabber.Exception, InterruptedException {

        String inputFile = "rtmp://push.chenchiding.com/kd-27/182422895381";
        // Decodes-encodes
        String outputFile="record.flv";

        try {
            getVideoDuration(new File(outputFile));
//            frameRecord(inputFile, outputFile,1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
