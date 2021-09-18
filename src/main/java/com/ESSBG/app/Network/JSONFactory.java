package com.ESSBG.app.Network;

import org.json.*;

/**
 * To produce easy passable statements for the networking module These types are
 * to help where to route the data.
 */
public class JSONFactory {
    /**
     * @param bool Connect parameter: bool ? "I want to connect" : "I want to
     *             disconnect";
     * @return a network json object.
     */
    protected static JSONObject getNetwork(boolean bool) {
        JSONObject json = JSONTemplate();
        json.put("reason", "net");
        json.put("data", bool);
        return json;
    }

    /**
     * NOT FOR CLIENT USE! This should only be used for a multiplayer server.
     *
     * @param bool Connect parameter: bool ? "I want to connect" : "I want to
     *             disconnect";
     * @param id   ID of the sender/receiver/user. To be able to identify who this
     *             is and who to reply to.
     * @return a network json object with id.
     */
    protected static JSONObject getNetworkWithID(boolean bool, int id) {
        JSONObject json = getNetwork(bool);
        json.put("id", id);
        return json;
    }

    /**
     * @param data The datastructure the server and the client agreed on.
     * @return a network json object.
     */
    protected static JSONObject getGame(JSONObject data) {
        JSONObject json = JSONTemplate();
        json.put("reason", "net");
        json.put("data", data);
        return json;
    }

    /**
     * @param data The datastructure the server and the client agreed on.
     * @param id   ID of the sender/receiver/user. To be able to identify who this
     *             is and who to reply to.
     * @return a network json object with id.
     */
    protected static JSONObject getGameWithID(JSONObject data, int id) {
        return getGame(data).put("id", id);
    }

    // Skeleton template for the jsons.
    private static JSONObject JSONTemplate() {
        JSONObject json = new JSONObject();
        json.put("reason", JSONObject.NULL);
        json.put("data", JSONObject.NULL);
        return json;
    }
}
