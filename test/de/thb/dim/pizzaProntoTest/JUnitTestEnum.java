package de.thb.dim.pizzaProntoTest;import de.thb.dim.pizzaPronto.valueObjects.Gender;import de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO;import org.junit.jupiter.api.BeforeEach;import org.junit.jupiter.api.DisplayName;import org.junit.jupiter.api.Test;import java.lang.reflect.Constructor;import java.lang.reflect.Field;import java.lang.reflect.Method;import java.lang.reflect.Modifier;import static org.junit.jupiter.api.Assertions.assertEquals;import static org.junit.jupiter.api.Assertions.assertTrue;/** * Enums are testet. *  *  * @author Gabriele Schmidt * @version 1.0 8.05.2015 */public class JUnitTestEnum {	private static Class<Gender> myGenderClass;	private static Class<StateOfOrderVO> myStateOfOrderVO;	@BeforeEach	public void initEach() throws Exception {		myGenderClass = Gender.class;		myStateOfOrderVO = StateOfOrderVO.class;	}	@Test	@DisplayName("test Gender is Enum")	public void testGenderIsEnum() {		assertTrue(myGenderClass.isEnum());	}	@Test	@DisplayName("test alls constants of Gender")	public void testGenderAllConstants() {		Field[] fields = myGenderClass.getDeclaredFields();		assertEquals(fields[0].toString(),				"public static final de.thb.dim.pizzaPronto.valueObjects.Gender de.thb.dim.pizzaPronto.valueObjects.Gender.M",				"Gender.M is a constant");		assertEquals(fields[1].toString(),				"public static final de.thb.dim.pizzaPronto.valueObjects.Gender de.thb.dim.pizzaPronto.valueObjects.Gender.F",				"Gender.F a is a constant");		assertEquals(fields[2].toString(),				"public static final de.thb.dim.pizzaPronto.valueObjects.Gender de.thb.dim.pizzaPronto.valueObjects.Gender.I",				"Gender.I is a constant");		assertEquals(fields[3].toString(),				"public static final de.thb.dim.pizzaPronto.valueObjects.Gender de.thb.dim.pizzaPronto.valueObjects.Gender.U",				"Gender.U is a constant");	}	@Test	@DisplayName("test constrctor of Gender is private")	public void testGenderConstructorIsPrivate() {		Constructor<?>[] constructors = myGenderClass.getDeclaredConstructors();		int modifiersConstructor = constructors[0].getModifiers();		assertTrue( Modifier.isPrivate(modifiersConstructor),"Constructor is private");	}		@Test	@DisplayName("test Gender has only 1 constrctor")	public void testGenderOnly1Constructor() {		Constructor<?>[] constructors = myGenderClass.getDeclaredConstructors();		assertEquals( 1, constructors.length,"Only one constructor");	}	@Test	@DisplayName("test Gender has method toString")	public void testGenderToString() {		boolean methodIsThere = false;		Method[] methoden = myGenderClass.getDeclaredMethods();		for(Method m : methoden) {			if(m.toString().equals(				"public java.lang.String de.thb.dim.pizzaPronto.valueObjects.Gender.toString()"))				methodIsThere = true;		}		assertTrue(methodIsThere);	}		@Test	@DisplayName("test Gender has method toNumber")	public void testGenderToNumber() {		boolean methodIsThere = false;		Method[] methoden = myGenderClass.getDeclaredMethods();		for(Method m : methoden) {			if(m.toString().equals(				"public int de.thb.dim.pizzaPronto.valueObjects.Gender.toNumber()"))				methodIsThere = true;		}		assertTrue(methodIsThere);	}	@Test	@DisplayName("test Gender has field number which is private")	public void testGenderAttributPrivate() throws NoSuchFieldException, SecurityException {		Field field = myGenderClass.getDeclaredField("number");		int modifiersAttribute = field.getModifiers();		assertTrue(Modifier.isPrivate(modifiersAttribute));	}		@Test	@DisplayName("test Gender has field number which is final")	public void testGenderAttributFinal() throws NoSuchFieldException, SecurityException {		Field field = myGenderClass.getDeclaredField("number");		int modifiersAttribute = field.getModifiers();		assertTrue(Modifier.isFinal(modifiersAttribute));	}	@Test	@DisplayName("test method toString of Gender is working correctly")	public void testGendertoSting() {		assertEquals("male",Gender.M.toString());		assertEquals("female",Gender.F.toString());		assertEquals("intersex",Gender.I.toString());		assertEquals("unknown",Gender.U.toString());	}		@Test	@DisplayName("test method toNumber of Gender is working correctly")	public void testGendertoNumber() {		assertEquals(1,Gender.M.toNumber());		assertEquals(2,Gender.F.toNumber());		assertEquals(3,Gender.I.toNumber());		assertEquals(4,Gender.U.toNumber());			}		@Test	@DisplayName("test StateOfOrderVO is Enum")	public void testStateOfOrderVOIsEnum() {		assertTrue(myStateOfOrderVO.isEnum());	}	@Test	@DisplayName("test alls constants of StateOfOrderVO")	public void testStateOfOrderVOAttributes() {		Field[] fields = myStateOfOrderVO.getDeclaredFields();			assertTrue(fields[0].toString().equals(				"public static final de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO.STARTED"),				"public static final de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO.STARTED");				assertTrue(fields[1].toString().equals(				"public static final de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO.CONFIRMED"),				"public static final de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO.CONFIRMED");				assertTrue(fields[2].toString().equals(				"public static final de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO.READY"),				"public static final de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO.READY");				assertTrue(fields[3].toString().equals(				"public static final de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO.DELIVERED"),				"public static final de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO.DELIVERED");				assertTrue(fields[4].toString().equals(				"public static final de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO.FINISHED"),				"public static final de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO.FINISHED");			}}