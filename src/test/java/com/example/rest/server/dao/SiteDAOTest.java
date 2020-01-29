package com.example.rest.server.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.rest.server.dao.SiteDAO;
import com.example.rest.server.model.SiteDO;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SiteDAOTest
{

  @Autowired
  private SiteDAO siteDAO;

  @Test
  public void test()
  {
    List<SiteDO> sites = siteDAO.findAll();
    sites.stream().forEach( s -> System.out.println( s ) );
  }

}
