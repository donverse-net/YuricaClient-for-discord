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
package Yurica;

import System.System;

public class Main {

    public static boolean runnable = false;

    public static String token;
    public static int shardId;
    public static int shardTotal;

    static System core = new System();

    // Discord bots
    static YuricaApp client;
    private static SlashCommandRegister slashCommandRegister;

    public static void main(String[] args) throws Exception {

        // Get args and set to variables
        token = args[0];
        shardId = Integer.parseInt(args[1]);
        shardTotal = Integer.parseInt(args[2]);

        // Create client
        client = new YuricaApp(token, shardId, shardTotal);
        client.CreateClient();

        // Create slash command register
        slashCommandRegister = new SlashCommandRegister(client.api);
        slashCommandRegister.register();

    }
}
