package com.bootcamp.repositories;

import com.bootcamp.entities.Produit;

public class ProduitRepository extends BaseRepository<Produit>{
    public ProduitRepository(String unitPersistence, Class entityClass) {
        super(unitPersistence, entityClass);
    }
}
