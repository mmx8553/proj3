import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.Arrays;

/**
 * Created by mmx on 06.02.2018.
 */
public class Main {
    public static void main(String[] args) {
        // Initialize Api Context
        ApiContextInitializer.init();

        KmzData kmzData = new KmzData();
//        System.out.println(Arrays.toString(kmzData.getModelList("Самосвал")));
        //System.out.println(kmzData.isModelParametr("4308"));
		
		//TODO TDD test ??? как и какой

        // Instantiate Telegram Bots API
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try{
            telegramBotsApi.registerBot(new KmzBot());
        }
        catch (TelegramApiException e){
            e.printStackTrace();
        }



    }
}
