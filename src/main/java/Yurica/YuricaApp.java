package Yurica;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

/**
 * Yurica Discord Bot
 */
public class YuricaApp {
    private String token;
    private int shardId;
    private int shardTotal;

    public JDA api = null;

    public YuricaApp(String token, int shardId, int shardTotal) {
        this.token = token;
        this.shardId = shardId;
        this.shardTotal = shardTotal;
    }

    /**
     * Create client. (JDABuilder.createDefault)
     * @throws Exception
     */
    public void CreateClient(){
        try {
            api = JDABuilder.createDefault(token)
                    .useSharding(shardId, shardTotal)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
