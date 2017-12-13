/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.loadDataFromJsonFile;

import com.bootcamp.TestUtils;
import com.bootcamp.commons.utils.GsonUtils;
import static com.bootcamp.commons.constants.DatabaseConstants.PERSISTENCE_UNIT;
import com.bootcamp.entities.Produit;
import com.bootcamp.entities.Region;
import com.bootcamp.entities.User;
import com.bootcamp.repositories.*;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.Test;
import java.io.File;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Iso-Doss
 */
public class loadDataFromJsonFileTest {

    private final NotificationRepository notificationRepository = new NotificationRepository(PERSISTENCE_UNIT);
    private final PostRepository postRepository = new PostRepository(PERSISTENCE_UNIT);
    private final ProduitRepository produitRepository = new ProduitRepository(PERSISTENCE_UNIT);
    private final RegionRepository regionRepository = new RegionRepository(PERSISTENCE_UNIT);
    private final UserRepository userRepository = new UserRepository(PERSISTENCE_UNIT);

    @Test(priority = 0, groups = {"load Data From JsonFile Test"})
    public void loadDataRegionFromJsonFile() throws Exception {
        TestUtils testUtils = new TestUtils();
        File dataFile = testUtils.getFile("data-json" + File.separator + "regions.json");

        String text = Files.toString(new File(dataFile.getAbsolutePath()), Charsets.UTF_8);

        Type typeOfObjectsListNew = new TypeToken<List<Region>>() {
        }.getType();
        List<Region> projets = GsonUtils.getObjectFromJson(text, typeOfObjectsListNew);

        for (int i = 0; i < projets.size(); i++) {
            Region get = projets.get(i);
            regionRepository.create(get);
        }

    }

    @Test(priority = 1, groups = {"load Data From JsonFile Test"})
    public void loadDataProduitFromJsonFile() throws Exception {
        TestUtils testUtils = new TestUtils();
        File dataFile = testUtils.getFile("data-json" + File.separator + "produits.json");

        String text = Files.toString(new File(dataFile.getAbsolutePath()), Charsets.UTF_8);

        Type typeOfObjectsListNew = new TypeToken<List<Produit>>() {
        }.getType();
        List<Produit> produits = GsonUtils.getObjectFromJson(text, typeOfObjectsListNew);
        for (int i = 0; i < produits.size(); i++) {
            Produit get = produits.get(i);
            produitRepository.create(get);
        }
    }

    @Test(priority = 2, groups = {"load Data From JsonFile Test"})
    public void loadDataUserFromJsonFile() throws Exception {
        TestUtils testUtils = new TestUtils();
        File dataFile = testUtils.getFile("data-json" + File.separator + "users.json");

        String text = Files.toString(new File(dataFile.getAbsolutePath()), Charsets.UTF_8);

        Type typeOfObjectsListNew = new TypeToken<List<User>>() {
        }.getType();
        List<User> users = GsonUtils.getObjectFromJson(text, typeOfObjectsListNew);
        Region region = regionRepository.findById(1);
        for (int i = 0; i < users.size(); i++) {
            User get = users.get(i);
            get.setRegion(region);
            userRepository.create(get);
        }
    }

}
