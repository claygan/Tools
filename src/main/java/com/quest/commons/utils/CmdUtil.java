package com.quest.commons.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Quest on 2017/7/25.
 */
public class CmdUtil {
    private static Logger log = LoggerFactory.getLogger(CmdUtil.class);

    public static String exec(Boolean isPrettify,String cmd, String... args) throws IOException {
        StringBuffer cmdout = new StringBuffer();
//        Process process = Runtime.getRuntime().exec(cmd);     //执行一个系统命令
        List<String> commands = new ArrayList<>();
        commands.add(cmd);
        for(String arg : args){
            commands.add(arg);
        }
        log.info("执行命令：" + commands.get(0)+" "+commands.get(1)+" "+commands.get(2));
        ProcessBuilder pb  = new ProcessBuilder().command(commands);

        Process process = pb.start();
        InputStream fis = process.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"GB2312"));//windows环境下默认GBK/GB2312
        String line = null;

        if (isPrettify == null || isPrettify) {
            while ((line = br.readLine()) != null) {
                cmdout.append(line);
            }
        } else {
            while ((line = br.readLine()) != null) {
                cmdout.append(line).append(System.getProperty("line.separator"));
            }
        }
        log.info("执行系统命令后的结果为：\n" + cmdout.toString());
        return cmdout.toString().trim();
    }
}
