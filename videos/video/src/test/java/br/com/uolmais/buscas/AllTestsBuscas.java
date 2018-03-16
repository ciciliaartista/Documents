package br.com.uolmais.buscas;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import br.com.player.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  TestChrome.class,
  TestFirefox.class,
  TestIE.class,
})
public class AllTestsBuscas {

}
