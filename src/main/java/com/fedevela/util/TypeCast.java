package com.fedevela.util;

/**
 * Created by fvelazquez on 26/03/14.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TypeCast {

    public static Object ifNull(Object o, Object r) {
        return ((o == null) ? r : o);
    }

    /**
     * Remplaza el valor s por r en caso de que se cumpla la condicion.
     * @param s, Valor
     * @param r, Remplazo
     * @return
     */
    public static String rplNullOrEmpty(String s, String r) {
        if (isNullOrEmpy(s)) {
            return r;
        } else {
            return s;
        }
    }

    /**
     * Fetch the entire contents of a text file, and return it in a String.
     * This style of implementation does not throw Exceptions to the caller.
     *
     * @param aFile is a file which already exists and can be read.
     */
    public static String toString(File aFile) {
        //...checks on aFile are elided
        StringBuilder contents = new StringBuilder();

        try {
            //use buffering, reading one line at a time
            //FileReader always assumes default encoding is OK!
            BufferedReader input = new BufferedReader(new FileReader(aFile));
            try {
                String line = null; //not declared within while loop
        /*
                 * readLine is a bit quirky :
                 * it returns the content of a line MINUS the newline.
                 * it returns null only for the END of the stream.
                 * it returns an empty String if two newlines appear in a row.
                 */
                while ((line = input.readLine()) != null) {
                    contents.append(line);
                    contents.append(System.getProperty("line.separator"));
                }
            } finally {
                input.close();
            }
        } catch (Exception ex) {
            return null;
        }
        return contents.toString();
    }

    public static String SF(Object v) {
        return CF("S", "0", 8, v);
    }

    public static String UF(Object v) {
        return CF("U", "0", 10, v);
    }

    public static String TF(Object v) {
        return CF("T", "0", 11, v);
    }

    /**
     * Customized format
     * @param prefix
     * @param v
     * @return
     */
    public static String CF(String prefix, String complete, int count, Object v) {
        return prefix + repeat(complete, (count - toString(v).length())) + v;
    }

    public static boolean isNull(Object o) {
        return o == null ? true : false;
    }

    public static boolean isNotNull(Object o) {
        return !isNull(o);
    }

    public static boolean isNullOrEmpy(String s) {
        return ((s == null) || (s.trim().equals("")));
    }

    public static boolean isNullOrEmpy(String s, String v) {
        s = (s != null) ? s.replaceAll(v, "") : s;
        return isNullOrEmpy(s);
    }

    public static char toChar(String s) {
        s = (isNullOrEmpy(s)) ? " " : s;
        return s.charAt(0);
    }

    public static Method getMethod(Class c, String n, Class p) {
        try {
            if (p == null) {
                return c.getMethod(n);
            } else {
                return c.getMethod(n, p);
            }
        } catch (Exception ex) {
            return null;
        }
    }

    public static Object invoke(Method m, Object o, Object p) {
        try {
            if (p == null) {
                return m.invoke(o);
            } else {
                return m.invoke(o, p);
            }
        } catch (Exception ex) {
            return null;
        }
    }

    public static Short toShort(Object o) {
        try {
            return toBigDecimal(o).shortValue();
        } catch (Exception e) {
            return null;
        }
    }

    public static BigDecimal toBigDecimal(Object o) {
        try {
            return new BigDecimal(toString(o));
        } catch (Exception e) {
            return null;
        }
    }

    public static BigInteger toBigInteger(Object o) {
        try {
            return new BigInteger(toString(o));
        } catch (Exception e) {
            return null;
        }
    }

    public static Integer toInteger(Object o) {
        try {
            return toBigDecimal(o).intValue();
        } catch (Exception e) {
            return null;
        }
    }

    public static Long toLong(Object o) {
        try {
            return toBigDecimal(o).longValue();
        } catch (Exception e) {
            return null;
        }
    }

    public static String toString(Object o) {
        try {
            if (o == null) {
                return null;
            } else {
                return String.valueOf(o);
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static String toString(Date d, String f) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(f.trim());
            df.setLenient(false); // Force read format date into param f
            return df.format(d);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Get Object by name, used reflections for find method
     * @param o
     * @param n
     * @return
     */
    public static Object GN(Object o, String n) {
        Method m = getMethod(o.getClass(), n, null);
        if (m != null) {
            return invoke(m, o, null);
        } else {
            return null;
        }
    }

    public static String toString(BigDecimal n, String f) {
        try {
            DecimalFormat df = new DecimalFormat(f.trim());
            return df.format(n);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     *
     * @param n, Value
     * @param f, Format
     * @param r, Replace value when is null
     * @return
     */
    public static String toString(BigDecimal n, String f, String r) {
        String rs = toString(n, f);
        if (isNullOrEmpy(rs)) {
            return r;
        } else {
            return rs;
        }
    }

    /**
     * @param n, value numeric
     * @param f, numeric format
     * @param d, default value when n is null
     */
    public static String toString(BigDecimal n, String f, BigDecimal d) {
        try {
            String rs = toString(n, f);
            return ((rs == null) ? toString(d, f) : rs);
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isNumber(Object o) {
        try {
            Double.parseDouble(toString(o));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static Date toDate(Object o, String f) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(f.trim());
            df.setLenient(false); // Force read format date into param f
            return df.parse(toString(o));
        } catch (Exception e) {
            return null;
        }
    }

    public static Date toDate(Date d, String f) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(f.trim());
            df.setLenient(false); // Force read format date into param f
            return df.parse(toString(d, f));
        } catch (Exception e) {
            return null;
        }
    }

    public static String toSoutFormat(String s) {
        String sf = "";
        for (int i = 0; i < s.length() + 4; i++) {
            sf += "*";
        }
        return sf + "\n" + "* " + s + " *\n" + sf + "\n";
    }

    public static Boolean toBoolean(Object o) {
        String s = toString(o);
        if (s != null) {
            s = s.trim().toUpperCase();
        } else {
            s = "N";
        }
        return (!s.equals("N")
                && !s.equals("NO")
                && !s.equals("F")
                && !s.equals("FALSE")
                && !((isNumber(s)) && (toInteger(s) == 0))
                && !s.equals("OFF"));
    }

    public static String repeat(String v, int size) {
        String rs = "";
        for (int i = 0; i < size; i++) {
            rs += v;
        }
        return rs;
    }
}

