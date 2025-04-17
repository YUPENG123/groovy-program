/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
// Excerpt of AbstractFactory.java - part of Groovy
public abstract class AbstractFactory implements Factory 
{
    public boolean isLeaf() { return false; }

    public boolean onHandleNodeAttributes(FactoryBuilderSupport builder, 
		Object node, Map attributes ) { return true; }

    public void onNodeCompleted(FactoryBuilderSupport builder, 
		Object parent, Object node ) { } 

    public void setParent(FactoryBuilderSupport builder, 
		Object parent, Object child ) { }

    public void setChild(FactoryBuilderSupport builder, 
		Object parent, Object child ) { }
}
