package visitor.reportprogram;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestBOMReport {
    private PiecePart p1 ;
    private PiecePart p2 ;
    private Assembly a ;

    @BeforeEach
    public void setUp(){
        p1=new PiecePart("997624","MyPart",3.20);
        p2=new PiecePart("7734","Hell",666);
        a=new Assembly("5879","MyAssembly");
    }

    @Test
    public void testCreate(){
        assertEquals("997624", p1.getPartNumber());
        assertEquals("7734", p2.getPartNumber());
        assertEquals("5879", a.getPartNumber());
    }

    @Test
    public void testAssembly(){
        a.add(p1);
        a.add(p2);
        List<Part> parts = a.getParts();
        Iterator<Part> it = parts.iterator();
        Part itp = it.next();
        Part itp2 = it.next();
        assertEquals(p1,itp);
        assertEquals(p2,itp2);
        assertFalse(it.hasNext());
    }
    @Test
    public void testAssemblyOfAssemblies(){
        Assembly subAssembly = new Assembly("1324", "SubAssembly");
        subAssembly.add(p1);
        a.add(subAssembly);

        List<Part> parts = a.getParts();
        Part itp = parts.iterator().next();
        assertEquals(subAssembly, itp);
    }

    private boolean p1Found = false;
    private boolean p2Found = false;
    private boolean aFound = false;
    @Test
    public void testVisitorCoverage(){
        a.add(p1);
        a.add(p2);
        a.accept(new PartVisitor() {
            @Override
            public void visit(Assembly assembly) {
                if(assembly == a) aFound = true;
            }
            @Override
            public void visit(PiecePart piecePart) {
                if(piecePart == p1) p1Found =true;
                else if(piecePart == p2) p2Found =true;
            }
        });
        assertTrue(p1Found);
        assertTrue(p2Found);
        assertTrue(aFound);
    }
}
