package io.pivotal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
//@EnableBinding(Source.class)
public class KafkaProducerApplication {
    List<String> givenNames;
    List<String> regionNames;
    Map<String, Long> userRegions = new HashMap<String, Long>();

    public KafkaProducerApplication() {
        this.setGivenName();
        this.setRegions();

        while (true) {
            this.sendMessage();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    //@InboundChannelAdapter(Source.OUTPUT)
    public String sendMessage() {
        String user = this.getGivenName();
        String region = this.getRegion();
        String userRegion = user + "," + region;

        // add region to a count
        Long regionCount = userRegions.get(region);
        if (regionCount != null) {
            regionCount++;
            userRegions.put(region, regionCount);
        } else {
            regionCount = new Long(1L);
            userRegions.put(region, regionCount);
        }

        System.out.println(region + "\t" + regionCount);

        return userRegion;
    }

    /**
     * initialize Map<String, String> givenName
     */
    public void setGivenName() {
        // Names generated by http://random-name-generator.info/
        if (givenNames != null) {
            return;
        }

        givenNames = new ArrayList<String>();
        givenNames.add("Ada");
        givenNames.add("Albert");
        givenNames.add("Alexandra");
        givenNames.add("Alfredo");
        givenNames.add("Allen");
        givenNames.add("Andre");
        givenNames.add("Angelica");
        givenNames.add("Anna");
        givenNames.add("Anthony");
        givenNames.add("Antonio");
        givenNames.add("Ashley");
        givenNames.add("Audrey");
        givenNames.add("Beatrice");
        givenNames.add("Benjamin");
        givenNames.add("Billy");
        givenNames.add("Bobby");
        givenNames.add("Bradley");
        givenNames.add("Bryant");
        givenNames.add("Candace");
        givenNames.add("Carole");
        givenNames.add("Carrie");
        givenNames.add("Claire");
        givenNames.add("Clifford");
        givenNames.add("Clint");
        givenNames.add("Clyde");
        givenNames.add("Cory");
        givenNames.add("Dale");
        givenNames.add("Danielle");
        givenNames.add("Daryl");
        givenNames.add("Delia");
        givenNames.add("Devin");
        givenNames.add("Douglas");
        givenNames.add("Eddie");
        givenNames.add("Ella");
        givenNames.add("Erica");
        givenNames.add("Erika");
        givenNames.add("Eva");
        givenNames.add("Frank");
        givenNames.add("Gayle");
        givenNames.add("George");
        givenNames.add("Georgia");
        givenNames.add("Geraldine");
        givenNames.add("Gina");
        givenNames.add("Gwen");
        givenNames.add("Hector");
        givenNames.add("Homer");
        givenNames.add("Irene");
        givenNames.add("James");
        givenNames.add("Jamie");
        givenNames.add("Jeremiah");
        givenNames.add("Joann");
        givenNames.add("Josefina");
        givenNames.add("Juan");
        givenNames.add("Karen");
        givenNames.add("Kenneth");
        givenNames.add("Laurie");
        givenNames.add("Lee");
        givenNames.add("Leland");
        givenNames.add("Leroy");
        givenNames.add("Levi");
        givenNames.add("Lewis");
        givenNames.add("Lillian");
        givenNames.add("Lillie");
        givenNames.add("Lorenzo");
        givenNames.add("Louise");
        givenNames.add("Lucas");
        givenNames.add("Lynn");
        givenNames.add("Marc");
        givenNames.add("Marcella");
        givenNames.add("Marlon");
        givenNames.add("Marvin");
        givenNames.add("Micheal");
        givenNames.add("Miranda");
        givenNames.add("Miriam");
        givenNames.add("Misty");
        givenNames.add("Naomi");
        givenNames.add("Natasha");
        givenNames.add("Nelson");
        givenNames.add("Oliver");
        givenNames.add("Pete");
        givenNames.add("Rafael");
        givenNames.add("Randall");
        givenNames.add("Raul");
        givenNames.add("Rebecca");
        givenNames.add("Reginald");
        givenNames.add("Roger");
        givenNames.add("Ruby");
        givenNames.add("Rufus");
        givenNames.add("Sabrina");
        givenNames.add("Sean");
        givenNames.add("Steven");
        givenNames.add("Stuart");
        givenNames.add("Terence");
        givenNames.add("Terry");
        givenNames.add("Van");
        givenNames.add("Velma");
        givenNames.add("Vincent");
        givenNames.add("Wanda");
        givenNames.add("Willard");
        givenNames.add("Winifred");


    }

    /**
     * retrieve a random entry in givenNames Map
     * @return
     */
    public String getGivenName() {
        Random randomNumber = new Random();

        return givenNames.get(randomNumber.nextInt(givenNames.size()));
    }

    /**
     * retrieve a random entry in regionNames Map
     * @return
     */
    public String getRegion() {
        Random randomNumber = new Random();

        return regionNames.get(randomNumber.nextInt(regionNames.size()));
    }

    /**
     * initialize Map<String, String> regionNames
     */
    public void setRegions() {
        // Names generated by http://random-name-generator.info/
        if (regionNames != null) {
            return;
        }

        regionNames = new ArrayList<String>();

        regionNames.add("north america");
        regionNames.add("central america");
        regionNames.add("south america");
        regionNames.add("carribean");
        regionNames.add("europe");
        regionNames.add("africa");
        regionNames.add("asia");
        regionNames.add("oceania");
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }
}
