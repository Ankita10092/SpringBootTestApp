package com.example.dao;

import java.util.List;
import com.example.entity.*;
import com.example.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnologyDAO {
    @Autowired
    TechnologyRepository tech_Repo;

    //Save
    public TechnologyModel save(TechnologyModel tech)
    {
        return tech_Repo.save(tech);
    }

    //Search
    public List<TechnologyModel> findAll()
    {
        return tech_Repo.findAll();
    }

    //updated
    public TechnologyModel findOne(Long techid)
    {
        return tech_Repo.getOne(techid);
    }

    //delete
    public TechnologyModel findOnedelete(Long techid)
    {
        return tech_Repo.getOne(techid);
    }

}
