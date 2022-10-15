public class HashtableChainTest {

    public static void main(String args[]){
        HashtableOpen<String,String> test = new HashtableOpen<>(11);
        HashtableOpen<Integer,Integer> test101 = new HashtableOpen<>(101);
        HashtableOpen<Integer,Integer> test1001 = new HashtableOpen<>(1001);
        HashtableOpen<Integer,Integer> test10001 = new HashtableOpen<>(10001);

        Integer Int[] = new Integer[100];


        test.put("osmn","osman");
        test.put("ali","ali");
        test.put("mehmet","mehmet");
        test.put("isma","ismail");
        test.put("ismai","osm");
        System.out.println(test.toString());
        test.put("o","osman");
        test.put("a","ali");
        test.put("m","mehmet");
        test.put("i","ismail");
        test.put("is","osm");

        test.put("o1","osman");
        test.put("a2","ali");
        test.put("m3","mehmet");
        test.put("i4","ismail");
        test.put("i5s","osm");
        test.put("i6s","osm");

        System.out.println("Rehashing....");
        System.out.println(test.toString());

        test.remove("osman");
        System.out.println(test.toString());
        System.out.println("Get 'ali':"+test.get("ali"));
        System.out.println("Get 'osman':"+test.get("osman"));
        System.out.println("Get 'ismai':"+test.get("ismai"));

        long startTime = System.nanoTime();
        for (int i=0; i < 100;i++){
            Int[i] = (int) (3200*Math.random());
            test101.put(Int[i],Int[i]);
        }
        System.out.println("Get:"+test101.get(Int[20]));
        System.out.println("Get:"+test101.get(1));
        System.out.println("Put:"+test101.put(1,2));
        System.out.println("Remove:"+test101.remove(Int[20]));

        long elapsedTime = System.nanoTime()- startTime;
        System.out.println("Total execution time with 100 table size: "+ elapsedTime);

        startTime = System.nanoTime();
        for (int i=0; i < 100;i++){
            test1001.put(Int[i],Int[i]);
        }
        System.out.println("Get:"+test1001.get(Int[20]));
        System.out.println("Get:"+test1001.get(1));
        System.out.println("Put:"+test1001.put(1,2));
        System.out.println("Remove:"+test1001.remove(Int[20]));
        elapsedTime = System.nanoTime()- startTime;
        System.out.println("Total execution time with 1000 table size: "+ elapsedTime);

        startTime = System.nanoTime();
        for (int i=0; i < 100;i++){
            test10001.put(Int[i],Int[i]);
        }
        System.out.println("Get:"+test10001.get(Int[20]));
        System.out.println("Get:"+test10001.get(1));
        System.out.println("Put:"+test10001.put(1,2));
        System.out.println("Remove:"+test10001.remove(Int[20]));
        elapsedTime = System.nanoTime()- startTime;
        System.out.println("Total execution time with 10000 table size: "+ elapsedTime);



    }
}
