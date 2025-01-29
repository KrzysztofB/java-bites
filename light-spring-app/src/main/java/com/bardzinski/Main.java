package com.bardzinski;

import com.bardzinski.com.bardzinski.lsa.presenter.LsaServer;

public class Main {
    public static void main(String[] args) {
        var server = new LsaServer();
        server.start();
    }
}