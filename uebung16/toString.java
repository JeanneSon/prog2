/**
     * 
    */
   public String toString(){
       StringBuffer sb = new StringBuffer("PersonQueue: ");
       PersonIterator iterator = new PersonIter();
       while (iterator.hasNext()) {
           sb  .append(iterator.next())
               .append("\n");
       }
       return sb.toString();
   }
   
   /**
     * 
    */
   public Person smallest (){
       PersonIterator iterator = new PersonIter();
       Person smallest = iterator.next();
       while (iterator.hasNext()) {
           Person test = iterator.next();
           int compare = smallest.compareTo(test);
           if (compare > 0)
                smallest = test;
            }
       return smallest;
   }
