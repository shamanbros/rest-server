package com.example.rest.server.commons.exception;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BusinessExceptionBuilderTest
{

  @Test
  public void testBuild()
  {
    BusinessException businessException = BusinessExceptionBuilder.build();
    Assert.assertNotNull( businessException );
    Assert.assertEquals( 0, businessException.getCode() );
    Assert.assertNotNull( businessException.getDescription() );
  }

  @Test
  public void testBuildString()
  {
    BusinessException businessException = BusinessExceptionBuilder.build( "An error has occured" );
    Assert.assertNotNull( businessException );
    Assert.assertEquals( 0, businessException.getCode() );
    Assert.assertNotNull( businessException.getDescription() );
  }

  @Test
  public void testBuildStringThrowable()
  {
    BusinessException businessException = BusinessExceptionBuilder.build( "An error has occured",
      new RuntimeException() );
    Assert.assertNotNull( businessException );
    Assert.assertEquals( 0, businessException.getCode() );
    Assert.assertNotNull( businessException.getDescription() );
  }

  @Test
  public void testBuildStringThrowableInt()
  {
    BusinessException businessException = BusinessExceptionBuilder.build( "An error has occured",
      new RuntimeException(), 1 );
    Assert.assertNotNull( businessException );
    Assert.assertEquals( 1, businessException.getCode() );
    Assert.assertNotNull( businessException.getDescription() );
  }

  @Test
  public void testBuildStringThrowableString()
  {
    BusinessException businessException = BusinessExceptionBuilder.build( "An error has occured",
      new RuntimeException(), "A description" );
    Assert.assertNotNull( businessException );
    Assert.assertEquals( 0, businessException.getCode() );
    Assert.assertNotNull( businessException.getDescription() );
  }

  @Test
  public void testBuildStringThrowableIntString()
  {
    BusinessException businessException = BusinessExceptionBuilder.build( "An error has occured",
      new RuntimeException(), 1, "A description" );
    Assert.assertNotNull( businessException );
    Assert.assertEquals( 1, businessException.getCode() );
    Assert.assertNotNull( businessException.getDescription() );
  }

  @Test
  public void testBuildInt()
  {
    BusinessException businessException = BusinessExceptionBuilder.build( 1 );
    Assert.assertNotNull( businessException );
    Assert.assertEquals( 1, businessException.getCode() );
    Assert.assertNotNull( businessException.getDescription() );
  }

  @Test
  public void testBuildThrowableInt()
  {
    BusinessException businessException = BusinessExceptionBuilder
        .build( new RuntimeException( "An error has occured" ), 1 );
    Assert.assertNotNull( businessException );
    Assert.assertEquals( 1, businessException.getCode() );
    Assert.assertNotNull( businessException.getDescription() );
  }

  @Test
  public void testBuildThrowable()
  {
    BusinessException businessException = BusinessExceptionBuilder
        .build( new RuntimeException( "An error has occured" ) );
    Assert.assertNotNull( businessException );
    Assert.assertEquals( 0, businessException.getCode() );
    Assert.assertNotNull( businessException.getDescription() );
  }
  
  
  @Test
  public void testBuild_error()
  {
    BusinessException businessException = BusinessExceptionBuilder.build( 100 );
    Assert.assertNotNull( businessException );
    Assert.assertEquals( 100, businessException.getCode() );
    Assert.assertEquals("",  businessException.getDescription() );
  }
}
