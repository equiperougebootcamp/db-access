package com.bootcamp.repositories;

import com.bootcamp.entities.Produit;

public class ProduitRepository extends BaseRepository<Produit>{
    public ProduitRepository(String persistUnit, Class entityClass) {
        super(persistUnit, entityClass);
    }
}
