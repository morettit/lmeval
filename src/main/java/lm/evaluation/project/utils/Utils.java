package lm.evaluation.project.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author tobia.moretti
 * @date 14/02/2018
 * @description utility class for static functions
 */
public class Utils {
	
	public static String evaluateBlank(String s) {
		return StringUtils.isNotBlank(s) ? s + " " : "";
	}
	
	public static String evaluateBlank(String prefix, String s) {
		return StringUtils.isNotBlank(prefix) && StringUtils.isNotBlank(s)
				? prefix + " " + evaluateBlank(s)
				: evaluateBlank(s);
	}
	
	public static String evaluateBlank(String prefix, String s, String suffix) {
		return StringUtils.isNotBlank(suffix) && StringUtils.isNotBlank(s)
				? evaluateBlank(prefix, s) + suffix + " "
				: evaluateBlank(prefix, s);
	}
}
