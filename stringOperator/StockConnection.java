import java.net.*;
import java.io.*;
public class StockConnection {
    public static void main(String[] args) {
        URL ur = null;
        try {
            //<a href="https://www.baidu.com/s?wd=%E6%90%9C%E7%8B%90&tn=44039180_cpr&fenlei=mv6quAkxTZn0IZRqIHckPjm4nH00T1Y3nAc4Phfkuj9buADvmWf40AP8IA3qPjfsn1bkrjKxmLKz0ZNzUjdCIZwsrBtEXh9GuA7EQhF9pywdQhPEUiqkIyN1IA-EUBtkrHmsnjT3P1mzn1b4rHb4rjms" target="_blank" class="baidu-highlight">搜狐</a>股票行情历史接口
//          ur = new URL("<a href="http://q.stock.sohu.com/hisHq?code=cn_300228&start=20130930&end=20131231&stat=1&order=D&period=d&callback=historySearchHandler&rt=jsonp"" target="_blank">http://q.stock.sohu.com/hisHq?code=cn_300228&start=20130930&end=20131231&stat=1&order=D&period=d&callback=historySearchHandler&rt=jsonp"</a>);
            ur = new URL("https://www.baidu.com/s?wd=%E6%96%B0%E6%B5%AA&tn=44039180_cpr&fenlei=mv6quAkxTZn0IZRqIHckPjm4nH00T1Y3nAc4Phfkuj9buADvmWf40AP8IA3qPjfsn1bkrjKxmLKz0ZNzUjdCIZwsrBtEXh9GuA7EQhF9pywdQhPEUiqkIyN1IA-EUBtkrHmsnjT3P1mzn1b4rHb4rjms\" target=\"_blank\" class=\"baidu-highlight");//>新浪</a>股票行情历史接口
            // ur = new URL("http://biz.finance.sina.com.cn/stock/flash_hq/kline_data.php?&rand=random\" target=\"_blank\">http://biz.finance.sina.com.cn/stock/flash_hq/kline_data.php?&rand=random</a>(10000)&symbol=sh600000&end_date=20150809&begin_date=20000101&type=plain");
            HttpURLConnection uc = (HttpURLConnection) ur.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ur.openStream(),"GBK"));
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}