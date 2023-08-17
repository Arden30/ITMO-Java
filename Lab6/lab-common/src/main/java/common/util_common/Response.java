package common.util_common;

import common.data.LabWork;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Response implements Serializable {
    private String messageToResponse;
    private LabWork labToResponse;
    private ArrayDeque<?> collectionToResponse;

    public Response(String messageToResponse) {
        this.messageToResponse = messageToResponse;
    }

    public Response(String messageToResponse, LabWork labToResponse) {
        this.messageToResponse = messageToResponse;
        this.labToResponse = labToResponse;
    }

    public Response(String messageToResponse, ArrayDeque<?> collectionToResponse) {
        this.messageToResponse = messageToResponse;
        this.collectionToResponse = collectionToResponse;
    }


    public Response(LabWork labToResponse) {
        this.labToResponse = labToResponse;
    }

    public Response(ArrayDeque<?> collectionToResponse) {
        this.collectionToResponse = collectionToResponse;
    }

    public String getMessageToResponse() {
        return messageToResponse;
    }

    public LabWork getLabToResponse() {
        return labToResponse;
    }

    public ArrayDeque<?> getCollectionToResponse() {
        return collectionToResponse;
    }

    public String getInfoAboutResponse() {
        return "Response contains: " + (messageToResponse == null ? "" : "message")
                + (labToResponse == null ? "" : ", LabWork")
                + (collectionToResponse == null ? "" : ", collection");
    }

    @Override
    public String toString() {
        StringBuilder collection = new StringBuilder();
        if (collectionToResponse != null) {
            List<?> labs = new ArrayList<>(collectionToResponse);
            //sortedLabs = sortedLabs.stream().sorted(Comparator.comparing(LabWork::getId)).collect(Collectors.toList());
            for (Object m : labs) {
                collection.append(m.toString()).append("\n");
            }
            collection = new StringBuilder(collection.substring(0, collection.length() - 1));
        }
        return (messageToResponse == null ? "" : messageToResponse)
                + (labToResponse == null ? "" : "\n" + labToResponse)
                + ((collectionToResponse == null) ? "" : "\n"
                + collection);
    }
}
