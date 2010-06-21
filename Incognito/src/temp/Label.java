package temp;

import symbol.Symbol;

/**
 * A Label represents an address in assembly language.
 */

public class Label  {
   private String name;
   private static int count;
   
   
   /**
    * Makes a new label that prints as "name".
    * Warning: avoid repeated calls to <tt>new Label(s)</tt> with
    * the same name <tt>s</tt>.
    */
    public Label(String n) {
    	name = n;
    }
    
    public Label(Symbol n) {
    	name = n.toString();
    }

   /**
    * Makes a new label with an arbitrary name.
    */
    public Label() {
    	this("L" + count++);
    }
    

  /**
   * a printable representation of the label, for use in assembly 
   * language output.
   */
   public String toString() {return name;}
}
