package Parser;

import Lexer.*;

/* Generated By:JavaCC: Do not edit this line. Incognito.java */
public class Incognito implements IncognitoConstants {
    public static void main(String args[]) throws ParseException
    {
        Incognito parser = null;

        if (args.length == 0){
        	System.out.println("Incognito: No input file.");
        }
        else if (args.length == 1) {
            System.out.println("Incognito: Reading from file " + args[0] + " ...");
            try {
            	parser = new Incognito(new java.io.FileInputStream(args[0]));
            }
            catch (java.io.FileNotFoundException e) {
                System.out.println("Incognito: File " + args[0] + " not found.");
                return;
            }
        }

        try {
            parser.Goal();
            System.out.println("Incognito: MiniJava program parsed successfully.");
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            System.out.println("Incognito: Encountered errors during parse.");
        }
    }

  static final public void Goal() throws ParseException {
    MainClass();
    label_1:
    while (true) {
      if (jj_2_1(2)) {
        ;
      } else {
        break label_1;
      }
      ClassDecl();
    }
    jj_consume_token(0);
  }

  static final public void MainClass() throws ParseException {
    jj_consume_token(CLASS);
    jj_consume_token(ID);
    jj_consume_token(LCURLYBRACE);
    jj_consume_token(MAIN);
    jj_consume_token(L_PARENTHESIS);
    jj_consume_token(STRING_ARRAY);
    jj_consume_token(ID);
    jj_consume_token(R_PARENTHESIS);
    jj_consume_token(LCURLYBRACE);
    Statement();
    jj_consume_token(RCURLYBRACE);
    jj_consume_token(RCURLYBRACE);
  }

  static final public void ClassDecl() throws ParseException {
    jj_consume_token(CLASS);
    jj_consume_token(ID);
    if (jj_2_2(2)) {
      jj_consume_token(EXTENDS);
      jj_consume_token(ID);
    } else {
      ;
    }
    jj_consume_token(LCURLYBRACE);
    label_2:
    while (true) {
      if (jj_2_3(2)) {
        ;
      } else {
        break label_2;
      }
      VarDecl();
    }
    label_3:
    while (true) {
      if (jj_2_4(2)) {
        ;
      } else {
        break label_3;
      }
      MethodDecl();
    }
    jj_consume_token(RCURLYBRACE);
  }

  static final public void VarDecl() throws ParseException {
    Type();
    jj_consume_token(ID);
    jj_consume_token(SEMICOLON);
  }

  static final public void MethodDecl() throws ParseException {
    jj_consume_token(PUBLIC);
    Type();
    jj_consume_token(ID);
    jj_consume_token(L_PARENTHESIS);
    FormalList();
    jj_consume_token(R_PARENTHESIS);
    jj_consume_token(LCURLYBRACE);
    label_4:
    while (true) {
      if (jj_2_5(2)) {
        ;
      } else {
        break label_4;
      }
      VarDecl();
    }
    label_5:
    while (true) {
      if (jj_2_6(2)) {
        ;
      } else {
        break label_5;
      }
      Statement();
    }
    jj_consume_token(RETURN);
    Exp();
    jj_consume_token(SEMICOLON);
    jj_consume_token(RCURLYBRACE);
  }

  static final public void FormalList() throws ParseException {
    if (jj_2_8(2)) {
      Type();
      jj_consume_token(ID);
      label_6:
      while (true) {
        if (jj_2_7(2)) {
          ;
        } else {
          break label_6;
        }
        FormalRest();
      }
    } else {

    }
  }

  static final public void FormalRest() throws ParseException {
    jj_consume_token(COMMA);
    Type();
    jj_consume_token(ID);
  }

  static final public void Type() throws ParseException {
    if (jj_2_9(2)) {
      jj_consume_token(INT_ARRAY);
    } else if (jj_2_10(2)) {
      jj_consume_token(BOOLEAN);
    } else if (jj_2_11(2)) {
      jj_consume_token(INT);
    } else if (jj_2_12(2)) {
      jj_consume_token(ID);
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Statement() throws ParseException {
    if (jj_2_14(2)) {
      jj_consume_token(LCURLYBRACE);
      label_7:
      while (true) {
        if (jj_2_13(2)) {
          ;
        } else {
          break label_7;
        }
        Statement();
      }
      jj_consume_token(RCURLYBRACE);
    } else if (jj_2_15(2)) {
      jj_consume_token(IF);
      jj_consume_token(L_PARENTHESIS);
      Exp();
      jj_consume_token(R_PARENTHESIS);
      Statement();
      jj_consume_token(ELSE);
      Statement();
    } else if (jj_2_16(2)) {
      jj_consume_token(WHILE);
      jj_consume_token(L_PARENTHESIS);
      Exp();
      jj_consume_token(R_PARENTHESIS);
      Statement();
    } else if (jj_2_17(2)) {
      jj_consume_token(PRINT);
      jj_consume_token(L_PARENTHESIS);
      Exp();
      jj_consume_token(R_PARENTHESIS);
      Statement();
      jj_consume_token(SEMICOLON);
    } else if (jj_2_18(2)) {
      jj_consume_token(ID);
      StatementFat();
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void StatementFat() throws ParseException {
    if (jj_2_19(2)) {
      jj_consume_token(ASSIGNEQUAL);
      Exp();
      jj_consume_token(SEMICOLON);
    } else if (jj_2_20(2)) {
      jj_consume_token(LSQUAREBRACKET);
      Exp();
      jj_consume_token(RSQUAREBRACKET);
      jj_consume_token(ASSIGNEQUAL);
      Exp();
      jj_consume_token(SEMICOLON);
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Op() throws ParseException {
    if (jj_2_21(2)) {
      jj_consume_token(AND);
    } else if (jj_2_22(2)) {
      jj_consume_token(LESS_THAN);
    } else if (jj_2_23(2)) {
      jj_consume_token(PLUS);
    } else if (jj_2_24(2)) {
      jj_consume_token(MINUS);
    } else if (jj_2_25(2)) {
      jj_consume_token(STAR);
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Exp() throws ParseException {
    if (jj_2_26(2)) {
      Term();
      ExpPrime();
    } else if (jj_2_27(2)) {
      jj_consume_token(EXCLAMATION);
      Exp();
    } else if (jj_2_28(2)) {
      jj_consume_token(L_PARENTHESIS);
      Exp();
      jj_consume_token(R_PARENTHESIS);
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void ExpPrime() throws ParseException {
    if (jj_2_29(2)) {
      Op();
      Term();
      ExpPrime();
    } else if (jj_2_30(2)) {
      jj_consume_token(LSQUAREBRACKET);
      Term();
      ExpPrime();
      jj_consume_token(RSQUAREBRACKET);
      ExpPrime();
    } else if (jj_2_31(2)) {
      jj_consume_token(DOT);
      Fat();
    } else {

    }
  }

  static final public void Fat() throws ParseException {
    if (jj_2_32(2)) {
      jj_consume_token(LENGTH);
      ExpPrime();
    } else if (jj_2_33(2)) {
      jj_consume_token(ID);
      jj_consume_token(L_PARENTHESIS);
      Explist();
      jj_consume_token(R_PARENTHESIS);
      ExpPrime();
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Term() throws ParseException {
    if (jj_2_34(2)) {
      jj_consume_token(INTEGER_LITERAL);
    } else if (jj_2_35(2)) {
      jj_consume_token(TRUE);
    } else if (jj_2_36(2)) {
      jj_consume_token(FALSE);
    } else if (jj_2_37(2)) {
      jj_consume_token(ID);
    } else if (jj_2_38(2)) {
      jj_consume_token(THIS);
    } else if (jj_2_39(2)) {
      jj_consume_token(NEW);
      Fat2();
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Fat2() throws ParseException {
    if (jj_2_40(2)) {
      jj_consume_token(INT);
      jj_consume_token(LSQUAREBRACKET);
      Exp();
      jj_consume_token(RSQUAREBRACKET);
    } else if (jj_2_41(2)) {
      jj_consume_token(ID);
      jj_consume_token(L_PARENTHESIS);
      jj_consume_token(R_PARENTHESIS);
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Explist() throws ParseException {
    if (jj_2_43(2)) {
      Exp();
      label_8:
      while (true) {
        if (jj_2_42(2)) {
          ;
        } else {
          break label_8;
        }
        Exprest();
      }
    } else {

    }
  }

  static final public void Exprest() throws ParseException {
    jj_consume_token(COMMA);
    Exp();
  }

  static private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  static private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  static private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  static private boolean jj_2_5(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  static private boolean jj_2_6(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  static private boolean jj_2_7(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_7(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(6, xla); }
  }

  static private boolean jj_2_8(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_8(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(7, xla); }
  }

  static private boolean jj_2_9(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_9(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(8, xla); }
  }

  static private boolean jj_2_10(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_10(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(9, xla); }
  }

  static private boolean jj_2_11(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_11(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(10, xla); }
  }

  static private boolean jj_2_12(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_12(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(11, xla); }
  }

  static private boolean jj_2_13(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_13(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(12, xla); }
  }

  static private boolean jj_2_14(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_14(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(13, xla); }
  }

  static private boolean jj_2_15(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_15(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(14, xla); }
  }

  static private boolean jj_2_16(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_16(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(15, xla); }
  }

  static private boolean jj_2_17(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_17(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(16, xla); }
  }

  static private boolean jj_2_18(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_18(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(17, xla); }
  }

  static private boolean jj_2_19(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_19(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(18, xla); }
  }

  static private boolean jj_2_20(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_20(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(19, xla); }
  }

  static private boolean jj_2_21(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_21(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(20, xla); }
  }

  static private boolean jj_2_22(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_22(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(21, xla); }
  }

  static private boolean jj_2_23(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_23(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(22, xla); }
  }

  static private boolean jj_2_24(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_24(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(23, xla); }
  }

  static private boolean jj_2_25(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_25(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(24, xla); }
  }

  static private boolean jj_2_26(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_26(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(25, xla); }
  }

  static private boolean jj_2_27(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_27(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(26, xla); }
  }

  static private boolean jj_2_28(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_28(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(27, xla); }
  }

  static private boolean jj_2_29(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_29(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(28, xla); }
  }

  static private boolean jj_2_30(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_30(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(29, xla); }
  }

  static private boolean jj_2_31(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_31(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(30, xla); }
  }

  static private boolean jj_2_32(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_32(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(31, xla); }
  }

  static private boolean jj_2_33(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_33(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(32, xla); }
  }

  static private boolean jj_2_34(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_34(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(33, xla); }
  }

  static private boolean jj_2_35(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_35(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(34, xla); }
  }

  static private boolean jj_2_36(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_36(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(35, xla); }
  }

  static private boolean jj_2_37(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_37(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(36, xla); }
  }

  static private boolean jj_2_38(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_38(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(37, xla); }
  }

  static private boolean jj_2_39(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_39(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(38, xla); }
  }

  static private boolean jj_2_40(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_40(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(39, xla); }
  }

  static private boolean jj_2_41(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_41(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(40, xla); }
  }

  static private boolean jj_2_42(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_42(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(41, xla); }
  }

  static private boolean jj_2_43(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_43(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(42, xla); }
  }

  static private boolean jj_3_20() {
    if (jj_scan_token(LSQUAREBRACKET)) return true;
    if (jj_3R_16()) return true;
    return false;
  }

  static private boolean jj_3R_15() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_19()) {
    jj_scanpos = xsp;
    if (jj_3_20()) return true;
    }
    return false;
  }

  static private boolean jj_3_19() {
    if (jj_scan_token(ASSIGNEQUAL)) return true;
    if (jj_3R_16()) return true;
    return false;
  }

  static private boolean jj_3_18() {
    if (jj_scan_token(ID)) return true;
    if (jj_3R_15()) return true;
    return false;
  }

  static private boolean jj_3_17() {
    if (jj_scan_token(PRINT)) return true;
    if (jj_scan_token(L_PARENTHESIS)) return true;
    return false;
  }

  static private boolean jj_3_16() {
    if (jj_scan_token(WHILE)) return true;
    if (jj_scan_token(L_PARENTHESIS)) return true;
    return false;
  }

  static private boolean jj_3_15() {
    if (jj_scan_token(IF)) return true;
    if (jj_scan_token(L_PARENTHESIS)) return true;
    return false;
  }

  static private boolean jj_3R_12() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_14()) {
    jj_scanpos = xsp;
    if (jj_3_15()) {
    jj_scanpos = xsp;
    if (jj_3_16()) {
    jj_scanpos = xsp;
    if (jj_3_17()) {
    jj_scanpos = xsp;
    if (jj_3_18()) return true;
    }
    }
    }
    }
    return false;
  }

  static private boolean jj_3_14() {
    if (jj_scan_token(LCURLYBRACE)) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_13()) { jj_scanpos = xsp; break; }
    }
    if (jj_scan_token(RCURLYBRACE)) return true;
    return false;
  }

  static private boolean jj_3_12() {
    if (jj_scan_token(ID)) return true;
    return false;
  }

  static private boolean jj_3_11() {
    if (jj_scan_token(INT)) return true;
    return false;
  }

  static private boolean jj_3_6() {
    if (jj_3R_12()) return true;
    return false;
  }

  static private boolean jj_3_10() {
    if (jj_scan_token(BOOLEAN)) return true;
    return false;
  }

  static private boolean jj_3R_14() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_9()) {
    jj_scanpos = xsp;
    if (jj_3_10()) {
    jj_scanpos = xsp;
    if (jj_3_11()) {
    jj_scanpos = xsp;
    if (jj_3_12()) return true;
    }
    }
    }
    return false;
  }

  static private boolean jj_3_9() {
    if (jj_scan_token(INT_ARRAY)) return true;
    return false;
  }

  static private boolean jj_3_7() {
    if (jj_3R_13()) return true;
    return false;
  }

  static private boolean jj_3R_13() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_14()) return true;
    return false;
  }

  static private boolean jj_3_42() {
    if (jj_3R_22()) return true;
    return false;
  }

  static private boolean jj_3_5() {
    if (jj_3R_10()) return true;
    return false;
  }

  static private boolean jj_3R_22() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_16()) return true;
    return false;
  }

  static private boolean jj_3_8() {
    if (jj_3R_14()) return true;
    if (jj_scan_token(ID)) return true;
    return false;
  }

  static private boolean jj_3_43() {
    if (jj_3R_16()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_42()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  static private boolean jj_3_41() {
    if (jj_scan_token(ID)) return true;
    if (jj_scan_token(L_PARENTHESIS)) return true;
    return false;
  }

  static private boolean jj_3R_21() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_40()) {
    jj_scanpos = xsp;
    if (jj_3_41()) return true;
    }
    return false;
  }

  static private boolean jj_3R_11() {
    if (jj_scan_token(PUBLIC)) return true;
    if (jj_3R_14()) return true;
    return false;
  }

  static private boolean jj_3_40() {
    if (jj_scan_token(INT)) return true;
    if (jj_scan_token(LSQUAREBRACKET)) return true;
    return false;
  }

  static private boolean jj_3_4() {
    if (jj_3R_11()) return true;
    return false;
  }

  static private boolean jj_3_3() {
    if (jj_3R_10()) return true;
    return false;
  }

  static private boolean jj_3R_10() {
    if (jj_3R_14()) return true;
    if (jj_scan_token(ID)) return true;
    return false;
  }

  static private boolean jj_3_39() {
    if (jj_scan_token(NEW)) return true;
    if (jj_3R_21()) return true;
    return false;
  }

  static private boolean jj_3_38() {
    if (jj_scan_token(THIS)) return true;
    return false;
  }

  static private boolean jj_3_37() {
    if (jj_scan_token(ID)) return true;
    return false;
  }

  static private boolean jj_3_36() {
    if (jj_scan_token(FALSE)) return true;
    return false;
  }

  static private boolean jj_3_2() {
    if (jj_scan_token(EXTENDS)) return true;
    if (jj_scan_token(ID)) return true;
    return false;
  }

  static private boolean jj_3_35() {
    if (jj_scan_token(TRUE)) return true;
    return false;
  }

  static private boolean jj_3R_17() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_34()) {
    jj_scanpos = xsp;
    if (jj_3_35()) {
    jj_scanpos = xsp;
    if (jj_3_36()) {
    jj_scanpos = xsp;
    if (jj_3_37()) {
    jj_scanpos = xsp;
    if (jj_3_38()) {
    jj_scanpos = xsp;
    if (jj_3_39()) return true;
    }
    }
    }
    }
    }
    return false;
  }

  static private boolean jj_3_34() {
    if (jj_scan_token(INTEGER_LITERAL)) return true;
    return false;
  }

  static private boolean jj_3_33() {
    if (jj_scan_token(ID)) return true;
    if (jj_scan_token(L_PARENTHESIS)) return true;
    return false;
  }

  static private boolean jj_3R_20() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_32()) {
    jj_scanpos = xsp;
    if (jj_3_33()) return true;
    }
    return false;
  }

  static private boolean jj_3_32() {
    if (jj_scan_token(LENGTH)) return true;
    if (jj_3R_18()) return true;
    return false;
  }

  static private boolean jj_3_1() {
    if (jj_3R_9()) return true;
    return false;
  }

  static private boolean jj_3R_9() {
    if (jj_scan_token(CLASS)) return true;
    if (jj_scan_token(ID)) return true;
    return false;
  }

  static private boolean jj_3R_23() {
    return false;
  }

  static private boolean jj_3_31() {
    if (jj_scan_token(DOT)) return true;
    if (jj_3R_20()) return true;
    return false;
  }

  static private boolean jj_3_30() {
    if (jj_scan_token(LSQUAREBRACKET)) return true;
    if (jj_3R_17()) return true;
    return false;
  }

  static private boolean jj_3R_18() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_29()) {
    jj_scanpos = xsp;
    if (jj_3_30()) {
    jj_scanpos = xsp;
    if (jj_3_31()) {
    jj_scanpos = xsp;
    if (jj_3R_23()) return true;
    }
    }
    }
    return false;
  }

  static private boolean jj_3_29() {
    if (jj_3R_19()) return true;
    if (jj_3R_17()) return true;
    return false;
  }

  static private boolean jj_3_28() {
    if (jj_scan_token(L_PARENTHESIS)) return true;
    if (jj_3R_16()) return true;
    return false;
  }

  static private boolean jj_3_27() {
    if (jj_scan_token(EXCLAMATION)) return true;
    if (jj_3R_16()) return true;
    return false;
  }

  static private boolean jj_3R_16() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_26()) {
    jj_scanpos = xsp;
    if (jj_3_27()) {
    jj_scanpos = xsp;
    if (jj_3_28()) return true;
    }
    }
    return false;
  }

  static private boolean jj_3_26() {
    if (jj_3R_17()) return true;
    if (jj_3R_18()) return true;
    return false;
  }

  static private boolean jj_3_25() {
    if (jj_scan_token(STAR)) return true;
    return false;
  }

  static private boolean jj_3_24() {
    if (jj_scan_token(MINUS)) return true;
    return false;
  }

  static private boolean jj_3_23() {
    if (jj_scan_token(PLUS)) return true;
    return false;
  }

  static private boolean jj_3_22() {
    if (jj_scan_token(LESS_THAN)) return true;
    return false;
  }

  static private boolean jj_3R_19() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_21()) {
    jj_scanpos = xsp;
    if (jj_3_22()) {
    jj_scanpos = xsp;
    if (jj_3_23()) {
    jj_scanpos = xsp;
    if (jj_3_24()) {
    jj_scanpos = xsp;
    if (jj_3_25()) return true;
    }
    }
    }
    }
    return false;
  }

  static private boolean jj_3_21() {
    if (jj_scan_token(AND)) return true;
    return false;
  }

  static private boolean jj_3_13() {
    if (jj_3R_12()) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public IncognitoTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[0];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[43];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public Incognito(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Incognito(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new IncognitoTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public Incognito(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new IncognitoTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public Incognito(IncognitoTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(IncognitoTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[42];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 0; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 42; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 43; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
            case 5: jj_3_6(); break;
            case 6: jj_3_7(); break;
            case 7: jj_3_8(); break;
            case 8: jj_3_9(); break;
            case 9: jj_3_10(); break;
            case 10: jj_3_11(); break;
            case 11: jj_3_12(); break;
            case 12: jj_3_13(); break;
            case 13: jj_3_14(); break;
            case 14: jj_3_15(); break;
            case 15: jj_3_16(); break;
            case 16: jj_3_17(); break;
            case 17: jj_3_18(); break;
            case 18: jj_3_19(); break;
            case 19: jj_3_20(); break;
            case 20: jj_3_21(); break;
            case 21: jj_3_22(); break;
            case 22: jj_3_23(); break;
            case 23: jj_3_24(); break;
            case 24: jj_3_25(); break;
            case 25: jj_3_26(); break;
            case 26: jj_3_27(); break;
            case 27: jj_3_28(); break;
            case 28: jj_3_29(); break;
            case 29: jj_3_30(); break;
            case 30: jj_3_31(); break;
            case 31: jj_3_32(); break;
            case 32: jj_3_33(); break;
            case 33: jj_3_34(); break;
            case 34: jj_3_35(); break;
            case 35: jj_3_36(); break;
            case 36: jj_3_37(); break;
            case 37: jj_3_38(); break;
            case 38: jj_3_39(); break;
            case 39: jj_3_40(); break;
            case 40: jj_3_41(); break;
            case 41: jj_3_42(); break;
            case 42: jj_3_43(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
