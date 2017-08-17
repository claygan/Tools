package com.quest.commons.utils;

import com.alibaba.druid.util.Utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CommonUtils {
	/**
	 * @param obj
	 * @return Float return zero if any Exception throw
	 */
	public static Float toFloat(Object obj) {
		return toFloat(obj, true);
	}
	/**
	 * @param obj
	 * @param zero: return zero if any Exception throw
	 * @return Float
	 */
	public static Float toFloat(Object obj, Boolean zero) {
		return toFloat(toString(obj, zero), zero);
	}

	/**
	 * @param str
	 * @return Integer return zero if any Exception throw
	 */
	public static Float toFloat(String str) {
		return toFloat(str, true);
	}

	/**
	 * @param str
	 * @param zero: return zero if any Exception throw
	 * @return Integer
	 */
	public static Float toFloat(String str, Boolean zero) {
		Float retFloat = 0.0f;

		try {
			retFloat = Float.parseFloat(str);
		} catch (Exception ex) {
			if (!zero)
				retFloat = null;
		}

		return retFloat;
	}

	/**
	 * @param obj
	 * @return Integer return zero if any Exception throw
	 */
	public static Integer toInteger(Object obj) {
		return toInteger(obj, true);
	}

	/**
	 * @param obj
	 * @param zero: return zero if any Exception throw
	 * @return Integer
	 */
	public static Integer toInteger(Object obj, Boolean zero) {
		return toInteger(toString(obj, zero), zero);
	}

	/**
	 * @param str
	 * @return Integer return zero if any Exception throw
	 */
	public static Integer toInteger(String str) {
		return toInteger(str, true);
	}

	/**
	 * @param str
	 * @param zero: return zero if any Exception throw
	 * @return Integer
	 */
	public static Integer toInteger(String str, Boolean zero) {
		Integer retInt = 0;

		try {
			retInt = Integer.parseInt(str);
		} catch (Exception ex) {
			if (!zero)
				retInt = null;
		}

		return retInt;
	}

	/**
	 * @param obj
	 * @return Short return zero if any Exception throw
	 */
	public static Short toShort(Object obj) {
		return toShort(obj, true);
	}

	/**
	 * @param obj
	 * @param zero: return zero if any Exception throw
	 * @return Short
	 */
	public static Short toShort(Object obj, Boolean zero) {
		return toShort(toString(obj, zero), zero);
	}

	/**
	 * @param str
	 * @return Short return zero if any Exception throw
	 */
	public static Short toShort(String str) {
		return toShort(str, true);
	}

	/**
	 * @param str
	 * @param zero: return zero if any Exception throw
	 * @return Short
	 */
	public static Short toShort(String str, Boolean zero) {
		Short retShort = 0;

		try {
			retShort = Short.parseShort(str);
		} catch (Exception ex) {
			if (!zero)
				retShort = null;
		}

		return retShort;
	}

	/**
	 * @param obj
	 * @return Long return zero if any Exception throw
	 */
	public static Long toLong(Object obj) {
		return toLong(toString(obj));
	}

	/**
	 * @param obj
	 * @param zero: return zero if any Exception throw
	 * @return Long
	 */
	public static Long toLong(Object obj, Boolean zero) {
		return toLong(toString(obj, zero), zero);
	}

	/**
	 * @param str
	 * @return Long return zero if any Exception throw
	 */
	public static Long toLong(String str) {
		return toLong(str, true);
	}

	/**
	 * @param str
	 * @param zero: return zero if any Exception throw
	 * @return Long
	 */
	public static Long toLong(String str, Boolean zero) {
		Long retLong = 0L;

		try {
			retLong = Long.parseLong(str);
		} catch (Exception ex) {
			if (!zero)
				retLong = null;
		}

		return retLong;
	}

    /**
     * @param obj
     * @return Long return zero if any Exception throw
     */
    public static Boolean toBoolean(Object obj) {
        return toBoolean(toString(obj));
    }

    /**
     * @param obj
     * @param zero: return zero if any Exception throw
     * @return Long
     */
    public static Boolean toBoolean(Object obj, Boolean zero) {
        return toBoolean(toString(obj, zero), zero);
    }

    /**
     * @param str
     * @return Long return zero if any Exception throw
     */
    public static Boolean toBoolean(String str) {
        return toBoolean(str, true);
    }

    /**
     * @param str
     * @param zero: return zero if any Exception throw
     * @return Long
     */
    public static Boolean toBoolean(String str, Boolean zero) {
        Boolean retBoolean = false;

        try {
            retBoolean = Boolean.parseBoolean(str);
        } catch (Exception ex) {
            if (!zero)
                retBoolean = null;
        }

        return retBoolean;
    }


    /**
	 * @param obj
	 * @return String return empty if any Exception throw
	 */
	public static String toString(Object obj) {
		return toString(obj, true);
	}

	/**
	 * @param obj
	 * @param zero: return empty if any Exception throw
	 * @return String
	 */
	public static String toString(Object obj, Boolean zero) {
		String retStr = "";

		try {
			retStr = obj.toString();
		} catch (Exception ex) {
			if (!zero)
				retStr = null;
		}

		return retStr;
	}

	public static Date toDate(Object object){
		return toDate(object, "yyyy-MM-dd");
	}

	public static Date toDateTime(Object object){
		return toDate(object, "yyyy-MM-dd HH:mm:ss");
	}

	public static Date toDate(Object object, String format){

		Date retDate = null;

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			retDate = sdf.parse(CommonUtils.toString(object));
		} catch (ParseException e) {
			return null;
		}

		return retDate;
	}

	public static Date gmtToDateTime(Object object){

		Date retDate = null;

		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH);
		try {
			retDate = toDateTime(sdf.parse(CommonUtils.toString(object)));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return retDate;
	}

	public static Date gmtToDateTime(Object object, String format){

		Date retDate = null;

		SimpleDateFormat sdf = new SimpleDateFormat(format,Locale.ENGLISH);
		try {
			retDate = toDateTime(sdf.parse(CommonUtils.toString(object)));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return retDate;
	}

	/**
	 * @param str
	 * @param len the length after truncated
	 * @return string after truncated
	 */
	public static String truncate(String str, Integer len) {
		if (str.length() > len) {
			return str.substring(0, len) + "...";
		} else {
			return str;
		}
	}

	/**
	 * 保存文件
	 *
	 * @param stream
	 * @param path
	 * @param filename
	 * @throws IOException
	 */
	public static void SaveFileFromInputStream(InputStream stream, String path, String filename) throws IOException {
		FileOutputStream fs = new FileOutputStream(path + "/" + filename);
		byte[] buffer = new byte[1024 * 1024];
		int bytesum = 0;
		int byteread = 0;
		while ((byteread = stream.read(buffer)) != -1) {
			bytesum += byteread;
			fs.write(buffer, 0, byteread);
			fs.flush();
		}
		fs.close();
		stream.close();
	}

	public static String getMD5Str(String str, String salt) {
		return getMD5Str(str + salt);
	}

	/**
	 * MD5 加密
	 */
	public static String getMD5Str(String str) {
		MessageDigest messageDigest = null;

		try {
			messageDigest = MessageDigest.getInstance("MD5");

			messageDigest.reset();

			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}

		return md5StrBuff.toString();
	}

	/*
	 * Java文件操作 获取文件扩展名
	 */
	public static String getExtensionName(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot > -1) && (dot < (filename.length() - 1))) {
				return filename.substring(dot + 1);
			}
		}
		return filename;
	}

    public static HashMap getSKey(HashMap map, String[] fieldArray, String search, String keyword){

        for(String str : fieldArray){
            if (search.length() == 0 || search.equals(str)) map.put(str, keyword);
        }

        return map;
    }

    public static String left(String str, int len) {
        if (str.length() <= len) return str;

        return str.substring(0, len) + "...";
    }
    public static String substr(String str, int start, int end) {
        return str.substring(start, end);
    }

    public static String markred(String str, String target){
		if (target.length() > 0) {
			String[] keys = target.split(" ");

			for (String key : keys) {
				str = str.replace(key, "<em class='red'>" + key + "</em>");
			}
		}
        return str;
    }

    public static String leftmarkred(String str, int len, String target){
        if (str.length() > len) str = str.substring(0, len) + "...";
		if (target.length() > 0) {
			String[] keys = target.split(" ");

			for (String key : keys) {
				str = str.replace(key, "<em class='red'>" + key + "</em>");
			}
		}
        return str;
    }

	public static String leftmarkredex(int id, String str, int len, String target){
		if (str.length() > len)
			str = str.substring(0, len) + "<span id='b"+id+"'>...［<a href=\"javascript:switchsummary("+id+");\" class=\"fontblue\">详细</a>］</span>" +
					"<span id='t"+id+"' style='display: none;'>" + str.substring(len, str.length()) + "</span>";

		if (target.length() > 0) {
			String[] keys = target.split(" ");

			for (String key : keys) {
				str = str.replace(key, "<em class='red'>" + key + "</em>");
			}
		}
		return str;
	}

	public static String getRandomChar(int length) {
		String val = "";
		String alphabet = "0123456789abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ";
		char[] chars = alphabet.toCharArray();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			val += chars[random.nextInt(alphabet.length())];
		}
		return val;
	}

	public static String getRandomNum(int length) {
		String val = "";
		String alphabet = "0123456789";
		char[] chars = alphabet.toCharArray();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			val += chars[random.nextInt(alphabet.length())];
		}
		return val;
	}

	public static void ConvertSkey(HashMap skey, int[] keys){

		if (skey != null) {
			if (skey.containsKey("order[0][column]") && Integer.parseInt(skey.get("order[0][column]").toString()) > 0) {
				if(CommonUtils.isEmpty(skey.get("columns[" + skey.get("order[0][column]").toString() + "][name]")))
				skey.put("orderbyclause", skey.get("columns[" + skey.get("order[0][column]").toString() + "][data]") + " " + skey.get("order[0][dir]"));
				else
					skey.put("orderbyclause", skey.get("columns[" + skey.get("order[0][column]").toString() + "][name]") + " " + skey.get("order[0][dir]"));

			}

			for(int key : keys){
				if (skey.containsKey("columns["+key+"][data]") &&
                        skey.containsKey("columns["+key+"][search][value]") &&
                        !skey.get("columns["+key+"][search][value]").toString().isEmpty()) {
                    skey.put(skey.get("columns["+key+"][data]"), skey.get("columns["+key+"][search][value]"));
                }
			}
		}
	}

	public static void ConvertSkey(HashMap skey, String[] values){

		if (skey != null) {
			if (skey.containsKey("order[0][column]") && Integer.parseInt(skey.get("order[0][column]").toString()) > 0) {
				skey.put("orderbyclause", skey.get("columns[" + skey.get("order[0][column]").toString() + "][data]") + " " + skey.get("order[0][dir]"));
			}

			for(String value : values){
//				if (skey.containsKey("columns["+key+"][search][value]")) { skey.put(skey.get("columns["+key+"][data]"), skey.get("columns["+key+"][search][value]")); }
			}
		}
	}

	public static Boolean isNotEmpty(Object obj){
		return !isEmpty(obj);
	}

	public static Boolean isEmpty(Object obj){
		if (obj == null) return true;

		if (obj.toString().isEmpty()) return true;

		return false;
	}

	public static Boolean hasKeyNotEmpty(HashMap map, Object key){
		if (map == null) return false;

		if (!map.containsKey(key)) return false;

		if (CommonUtils.isEmpty(map.get(key))) return false;

		return true;
	}

    public static String ID19D(){
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        return df.format(date.getTime()) +  new Random().nextInt(99);
    }

    public static String getRequestBodyFromMap(Map parametersMap, boolean isUrlEncoding/*,String charset*/) {
        StringBuffer sbuffer = new StringBuffer();
        for(Object obj:parametersMap.keySet()){
            String value=(String) parametersMap.get(obj);
            if(isUrlEncoding){
                try {
                    value = URLEncoder.encode(value, "UTF-8");
                    if(isNotEmpty(value)){
                        parametersMap.put(obj, value);
                    }
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }
            }
            sbuffer.append(obj).append("=").append(value).append("&");
        }
        return sbuffer.toString().replaceAll("&$", "");

    }

	public static boolean sqlInj(String str)
	{
		String inj_str = "'| and |exec|insert|select|delete|update| count|*|%|chr|mid|master|truncate|char|declare|;| or |-|+|,";
		String inj_stra[] = inj_str.split("[|]");
		for (int i=0 ; i< inj_stra.length ; i++ )
		{
			if (str.indexOf(inj_stra[i])>=0)
			{
				return true;
			}
		}
		return false;
	}

}
