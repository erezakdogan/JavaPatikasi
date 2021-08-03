package generic;
import java.util.ArrayList;

public class MyList<T>{
int capacity=10;

ArrayList<T> list;

MyList(){
    this.list= new  ArrayList<T>(10);
}




public void add(T t){
    list.add(t);
}



 public int getCapacity() {
    if(getSize()>capacity){
        return this.capacity = capacity*2;
     }else{
        return this.capacity = 10;            
     }
    }

    public int getSize() {
        return list.size();
    }

    public T get(int index){
        return list.get(index);
    }

    public void remove(int index){
        list.remove(index);
    }

    public void set(int index, T data){
        list.set(index, data);
    }
    public String toString(){
        String srt ="";
      for(T i :list){
         srt+= (i.toString()+" ");
      } 
    return srt;
    }

    public int indexOf(T t){
    
    if(!list.contains(t)){
    return -1;
    }
    return list.indexOf(t);
    }
    
    public int lastIndexOf(T t){
    
        if(!list.contains(t)){
        return -1;
        }
        int a=0;
        for(int i=list.size()-1; i>0;i--){
            if(list.get(i)==t){
             a += i;
             break;
            }
            
        }
        return a;
        }
        public boolean isEmpty(){
            return list.isEmpty();
        }

        public void clear(){
            list.clear();
        }
        
        public MyList<T> sublist(int a,int b){
            MyList<T> arrayList = new MyList<>();
            for(int i = a; i<b+1; i++){
                arrayList.add(list.get(i));
            }
            return arrayList;
        }


    public boolean isContains(T data){
        return list.contains(data);
    }



}

   
