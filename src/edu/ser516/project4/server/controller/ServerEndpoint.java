package edu.ser516.project4.server.controller;

import edu.ser516.project4.client.model.StatusDecoder;
import edu.ser516.project4.client.model.StatusEncoder;
import edu.ser516.project4.server.view.components.Console;

import javax.websocket.*;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;
import static edu.ser516.project4.common.constants.NetworkConstants.STATUS_ENDPOINT;

/**
 * Endpoint clients hit when sending messages over the websocket
 * @author Team 7
 *
 */
@javax.websocket.server.ServerEndpoint(value = "/" + STATUS_ENDPOINT, encoders = StatusEncoder.class, decoders = StatusDecoder.class)
public class ServerEndpoint {

    static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

    /**
     * Called when a new connection opens
     *
     * @param  session the session object describing the client that opened a connection
     *
     */
    @OnOpen
    public void onOpen(Session session) throws IOException {
        peers.add(session);
        Console.setMessage(session.getId() + " is connected. Number of connections: " + peers.size());
    }

    /**
     * Called when a connection closes
     * @author sessios the session object describing the client that closed its connection
     *
     */
    @OnClose
    public void onClose(Session session) throws IOException, EncodeException {
        System.out.println(format("%s stopped its connection.", session.getId()));
        peers.remove(session);
    }
}