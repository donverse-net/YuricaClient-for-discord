package yurica;

import java.util.Scanner;

public class Core {
    public void CheckArgs(String[] args){
        if (args.length == 0) {
            System.out.println("No arguments provided. Starting with no shard client. (token)");
            Main.runnable = false;
            return;
        }

        if (args.length == 1) {
            System.out.println("No arguments provided. Starting with no shard client. (shard id)");
            Main.runnable = false;
            return;
        }

        if (args.length == 2) {
            System.out.println("No arguments provided. Starting with no shard client. (total shards)");
            Main.runnable = false;
            return;
        }

        if (args.length == 3) {
            System.out.println("Starting with shard client.");
            Main.runnable = true;
            return;
        }

        if (args.length > 3) {
            System.out.println("Too many arguments provided. Starting with no shard client. (token shardId shardTotal)");
            Main.runnable = false;
            return;
        }
    }

    public void SetConfig(String first, String second, String third){
        try{
            int id;
            int total;

            if (second.equals("0") || third.equals("0")) {
                System.out.println("No arguments provided. Starting with no shard client.");
                id = 0;
                total = 0;
            }

            try {
                id = Integer.parseInt(second);
            } catch (Exception e){
                System.out.println(e);
                id = 0;
            }

            try {
                total = Integer.parseInt(third);
            } catch (Exception e) {
                System.out.println(e);
                total = 0;
            }

            Main.token = first;
            Main.shardId = id;
            Main.shardTotal = total;
        } catch (Exception e){
            System.out.println("Invalid arguments or no arguments provided.");
            return;
        }
    }

    private String help =
            "\n" +
            "---------------------------------------\n\n" +
            "Command usage: [cmd] <opt>...\n" +
            "\n" +
            "help - Show help.\n" +
            "stop - Stop the bot.\n" +
            "clear - Clear the console.\n\n" +
            "---------------------------------------" +
            "\n";

    public void consoleInput(){

        while (Main.runnable) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("yurica> ");

            String input = scanner.nextLine();
            switch(input) {
                case "help":
                    System.out.println(help);
                    break;
                case "clear":
                    for (int i = 0; i < 50; ++i) {
                        System.out.print("\n");
                    }
                    break;
                case "stop":
                    System.out.println("Stopping...");
                    Main.client.logoutFromClient();
                    Main.runnable = false;
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Unknown command. Type \"help\" for help.");
                    break;
            }
        }
    }
}
