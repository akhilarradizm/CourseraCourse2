import java.util.*;
import edu.duke.*;
public class LogAnalyzer {
    private ArrayList<LogEntry> records;
    int index;

    public LogAnalyzer() {
        records = new ArrayList<LogEntry>();
    }

    public void readFile(String filename) {
        FileResource f = new FileResource(filename);
        for (String s : f.lines()) {
            LogEntry entry = WebLogParser.parseEntry(s);
            records.add(entry);
        }
    }

    public void printAll() {
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }

    public int countUniqueIPs() {
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for (LogEntry l : records) {
            String ip = l.getIPAddress();
            if (!uniqueIPs.contains(ip)) {
                uniqueIPs.add(ip);
            }
        }
        return uniqueIPs.size();
    }

    public void printAllHigherThanNum(int num) {
        for (LogEntry l : records) {
            if (l.getStatusCode() > num) {
                System.out.println(l);
            }
        }
    }

    public ArrayList uniqueIPVisitsOnDay(String someday) {
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for (LogEntry le : records) {
            Date d = le.getAccessTime();
            String str = d.toString();
            String date = str.substring(4, 10);
            String ip = le.getIpAddress();
            if (date.equals(someday) && !uniqueIPs.contains(ip)) {
                uniqueIPs.add(ip);
            }
        }
        return uniqueIPs;
    }

    public int countUniqueIPsInRange(int low, int high) {
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for (LogEntry l : records) {
            int status = l.getStatusCode();
            String ip = l.getIpAddress();
            if (status >= low && status <= high && !uniqueIPs.contains(ip)) {
                uniqueIPs.add(ip);
            }
        }
        return uniqueIPs.size();
    }
    public HashMap countVisitsPerIP(){
        HashMap<String,Integer> countMap = new HashMap<String,Integer>();
        for(LogEntry le: records){
            String ip = le.getIpAddress();
            if(!countMap.containsKey(ip)){
                countMap.put(ip,1);
            }
            else {
                countMap.put(ip, countMap.get(ip)+1);
            }
        }
        return countMap;
    }
    public int mostNumberVisitsByIP(HashMap<String, Integer> counts){
        int mostVisits = 0;
        for (int num : counts.values()){
            if (mostVisits < num){
                mostVisits = num;
            }
        }
        return mostVisits;
    }
    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> map){
        int indexMap = 0;
        for (ArrayList s: map.values()){
            if(indexMap < s.size()){
                indexMap = s.size();
            }
        }
        for(String s: map.keySet()){
            ArrayList ips = map.get(s);
            if(indexMap == ips.size()){
                return s;
            }
        }
        return null;
    }

    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> map, String day){
        for (String s: map.keySet()){
            if (s.contains(day)){
                return map.get(s);
            }
        }
        return null;
    }
}
class Tester
{
    public void testLogAnalyzer()
    {
        LogAnalyzer analyzer = new LogAnalyzer();
        analyzer.readFile("weblog3-short_log");
        analyzer.printAll();
    }
    public void testUniqueIP()
    {
        LogAnalyzer read = new LogAnalyzer();
        read.readFile("weblog2_log");
        System.out.println("There are " + read.countUniqueIPs()+ " different IPs");
    }

    public static void main(String[] args) {
        Tester test = new Tester();
        test.testLogAnalyzer();
        test.testUniqueIP();
    }
}