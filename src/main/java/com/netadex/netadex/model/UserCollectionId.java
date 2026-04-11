package com.netadex.netadex.model;

import java.io.Serializable;
import java.util.Objects;

public class UserCollectionId implements Serializable {

    private Long user;
    private Long politician;

    public UserCollectionId() {}

    public UserCollectionId(Long user, Long politician) {
        this.user = user;
        this.politician = politician;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserCollectionId)) return false;
        UserCollectionId that = (UserCollectionId) o;
        return Objects.equals(user, that.user) &&
               Objects.equals(politician, that.politician);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, politician);
    }
}