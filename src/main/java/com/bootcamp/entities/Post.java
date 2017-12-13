package com.bootcamp.entities;

import com.bootcamp.commons.annotations.NativeQueryResultColumn;
import com.bootcamp.enums.StatutPost;
import com.bootcamp.enums.TypePost;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @ApiModelProperty(value = "Id of the post", notes = "This id is automatically generated ,it doesn't required")
    private int id;

    @Column(nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @ApiModelProperty(value = "type of the post", required = false)
    private TypePost typePost;


    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @ApiModelProperty(value = "status of the post", required = false)
    private StatutPost statutPost;

    @ApiModelProperty(value = "Created date of the post")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private long dateCreation;

    @ApiModelProperty(value = "Update date of the post")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private long dateMiseAJour;

    @ApiModelProperty(value = "user id   of the post")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private int userId;

    @ApiModelProperty(value = "product id   of the post")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private int produitId;

    @ApiModelProperty(value = "postulant id   of the post")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private List<Integer> postulantId;

    @ApiModelProperty(value = "The region of post", required = true)
    @JoinColumn(name = "region", referencedColumnName = "id", insertable = false, updatable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.COMPLEX)
    private Region region;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypePost getTypePost() {
        return typePost;
    }

    public void setTypePost(TypePost typePost) {
        this.typePost = typePost;
    }

    public StatutPost getStatutPost() {
        return statutPost;
    }

    public void setStatutPost(StatutPost statutPost) {
        this.statutPost = statutPost;
    }

    public long getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(long dateCreation) {
        this.dateCreation = dateCreation;
    }

    public long getDateMiseAJour() {
        return dateMiseAJour;
    }

    public void setDateMiseAJour(long dateMiseAJour) {
        this.dateMiseAJour = dateMiseAJour;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProduitId() {
        return produitId;
    }

    public void setProduitId(int produitId) {
        this.produitId = produitId;
    }

    public List<Integer> getPostulantId() {
        return postulantId;
    }

    public void setPostulantId(List<Integer> postulantId) {
        this.postulantId = postulantId;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
