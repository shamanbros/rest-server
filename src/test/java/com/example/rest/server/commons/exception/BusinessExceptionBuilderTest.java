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
    BusinessException businessException = BusinessExceptionBuilder.build("An error has occured");
    Assert.assertNotNull( businessException );
    Assert.assertEquals( 0, businessException.getCode() );
    Assert.assertNotNull( businessException.getDescription() );
  }

  @Test
  public void testBuildStringThrowable()
  {
    fail( "Not yet implemented" );
  }

  @Test
  public void testBuildStringThrowableInt()
  {
    fail( "Not yet implemented" );
  }

  @Test
  public void testBuildStringThrowableString()
  {
    fail( "Not yet implemented" );
  }

  @Test
  public void testBuildStringThrowableIntString()
  {
    fail( "Not yet implemented" );
  }

}
