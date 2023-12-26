//
// Yurica Discord Bot
// Author: https://github.com/KaRU3-dev
// Created since: 2023-12-01
// Copyright: Donverse.net (c) All rights reserved.
//
// Usage:
//  java -jar yuricaAPI-{version}.jar <token> <shardId> <shardTotal>
//
// Recommended:
//  Use Docker to run this bot.
//  Manage your bot with Docker Compose and k8s.
//  Use Kubernetes to manage your bot cluster.
//
//  Link:
//     https://yurica.donverse.net/docs
//     https://www.docker.com/
//     https://docs.docker.com/compose/
//     https://kubernetes.io/
//
package yurica;

import net.dv8tion.jda.api.JDA;

public class Main {

    public static boolean runnable = false;

    public static String token;
    public static int shardId;
    public static int shardTotal;

    static Core core = new Core();
    static Client client = new Client();

    public static JDA jda = null;

    public static void main(String[] args) {
        String[] arg = args;

        // Check if arguments are valid.
        core.CheckArgs(arg);

        // Cannot run if no arguments are provided.
        if (!runnable) {
            return;
        }

        // Set config.
        core.SetConfig(arg[0], arg[1], arg[2]);
        // Login to client with shard.
        client.LoginToCLientWithShard(token, shardId, shardTotal);

    }
}
