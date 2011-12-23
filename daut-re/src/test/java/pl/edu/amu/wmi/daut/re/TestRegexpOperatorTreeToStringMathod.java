package pl.edu.amu.wmi.daut.re;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.List;

/**
 * Test metody ToString znajdującej się w klasie RegexpOperatorTree.
 */
public class TestRegexpOperatorTreeToStringMathod extends TestCase {
    /**
     * Testuje drzewo powstałe z użycia SingleCharacterOPerator - a .
     */
    public final void TestTreeFromSingleCharacterOperator() throws Exception{

        List<RegexpOperatorTree> subtrees = new ArrayList<RegexpOperatorTree>();

        SingleCharacterOperator a = new SingleCharacterOperator('a');
        RegexpOperatorTree completeTree = new RegexpOperatorTree(a, subtrees);

       // String Tree = completeTree.ToString();
       // assertTrue(Tree.equals("a lub inny napis od karola"));
    }

    /**
     * Testuje drzewo powstające z urzycia operatora alternatywy - a|b .
     */
    public final void testTreeFromAlternativeOperator() throws Exception{

        List<RegexpOperatorTree> subtrees = new ArrayList<RegexpOperatorTree>();

        SingleCharacterOperator aOp = new SingleCharacterOperator('a');
        RegexpOperatorTree charATr = new RegexpOperatorTree(aOp, subtrees);

        SingleCharacterOperator bOp = new SingleCharacterOperator('b');
        RegexpOperatorTree charBTr = new RegexpOperatorTree(bOp, subtrees);

        subtrees.add(charATr);
        subtrees.add(charBTr);
        AlternativeOperator alternative = new AlternativeOperator();
        RegexpOperatorTree CompleteTree = new RegexpOperatorTree(alternative, subtrees);

       //String Tree = completeTree.toString();
       // assertTrue(Tree.equals("alternatywa nizej a i b"));
    }

    /**
     * Testuje drzewo powstałe z użycia wyrażenia ((a* anyOrderOperator b*) | c?).
     */
    public final void testTreeFromCombinationOfOperators() throws Exception{

        List<RegexpOperatorTree> subtrees = new ArrayList<RegexpOperatorTree>();

        SingleCharacterOperator aOp = new SingleCharacterOperator('a');
        RegexpOperatorTree charATr = new RegexpOperatorTree(aOp, subtrees);

        SingleCharacterOperator bOp = new SingleCharacterOperator('b');
        RegexpOperatorTree charBTr = new RegexpOperatorTree(bOp, subtrees);

        SingleCharacterOperator cOp = new SingleCharacterOperator('c');
        RegexpOperatorTree charCTr = new RegexpOperatorTree(cOp, subtrees);

        KleeneStarOperator kleeneAOp = new KleeneStarOperator();
        subtrees.add(charATr);
        RegexpOperatorTree kleeneCharATr = new RegexpOperatorTree(kleeneAOp, subtrees);
        subtrees.clear();

        KleeneStarOperator kleeneBOp = new KleeneStarOperator();
        subtrees.add(charBTr);
        RegexpOperatorTree kleeneCharBTr = new RegexpOperatorTree(kleeneBOp, subtrees);
        subtrees.clear();

        AnyOrderOperator anyOrderOp = new AnyOrderOperator();
        subtrees.add(kleeneCharATr);
        subtrees.add(kleeneCharBTr);
        RegexpOperatorTree anyOrderOfKleeneStarsTr = new RegexpOperatorTree(anyOrderOp, subtrees);
        subtrees.clear();

        OptionalityOperator optionallyCharCOp = new OptionalityOperator();
        subtrees.add(charCTr);
        RegexpOperatorTree optionallyCharCTr = new RegexpOperatorTree(optionallyCharCOp, subtrees);
        subtrees.clear();

        AlternativeOperator alternativeOp = new AlternativeOperator();
        subtrees.add(optionallyCharCTr);
        subtrees.add(anyOrderOfKleeneStarsTr);
        RegexpOperatorTree completeTree = new RegexpOperatorTree(alternativeOp, subtrees);

        //String Tree = completeTree.toString();
       // assertTrue(Tree.equals("alternatywa nizej a i b"));
    }

}
