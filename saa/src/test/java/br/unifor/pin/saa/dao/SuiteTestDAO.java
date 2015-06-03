
package br.unifor.pin.saa.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AlunoDAOTest.class, AulasDAOTest.class,
		AvaliacoesDAOTest.class, InstituicoesDAOTest.class,
		ProfessoresDAOTest.class, TurmaDAOTest.class,UsuarioDAOTest.class })
public class SuiteTestDAO {

}