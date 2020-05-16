/**
     * 
    */
   public String toString(){
       ArrayList person = new ArrayList();
       StringBuffer sb = new StringBuffer("PersonQueue: ");
       Iterator iterator = person.iterator();
       while (iterator.hasNext()) {
           sb  .append(iterator.next())
               .append("\n");
       }
       return sb.toString();
   }
   
   /**
     * 
    */
   public String smallest (){
       ArrayList person = new ArrayList();
       Iterator iterator = person.iterator();
       String smallest = iterator.stream().findFirst().orElse("not found");
       while (iterator.hasNext()) {
           String test = iterator.next();
           int compare = smallest.compareTo(test);
           if (compare > 0)
                smallest = test;
            }
       return smallest;
   }
