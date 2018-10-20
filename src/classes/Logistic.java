package classes;

import java.io.Serializable;

public class Logistic {


    private int id;
    private String good;
    private String town;
    private String address;
    private String store;
    private String representation;
    private String client;
    private String route;
    private String transport;
    private String status;

    public Logistic(int id, String good, String town, String address, String store, String representation, String client, String route, String transport, String status) {
        this.id = id;
        this.good = good;
        this.town = town;
        this.address = address;
        this.store = store;
        this.representation = representation;
        this.client = client;
        this.route = route;
        this.transport = transport;
        this.status = status;
    }

    public Logistic(){ }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getRepresentation() {
        return representation;
    }

    public void setRepresentation(String representation) {
        this.representation = representation;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Logistic{" +
                "id=" + id +
                ", good='" + good + '\'' +
                ", town='" + town + '\'' +
                ", address='" + address + '\'' +
                ", store='" + store + '\'' +
                ", representation='" + representation + '\'' +
                ", client='" + client + '\'' +
                ", route='" + route + '\'' +
                ", transport='" + transport + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
