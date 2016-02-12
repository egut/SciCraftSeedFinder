package com.scicraft.seedfinder;

public class bitIterator {
	private long baseSeed, current;
	private long baseEnd = 65536; 
	
	/*
	 * insert potential seed to do whatever with first 16 bits this class iterates over all of them
	 * use this class to for example to check biomes
	 * use this as a normal iterator: while(hasNext()){bitIterator.next()}
	 */
	public bitIterator(long baseSeed){
		this.baseSeed = baseSeed & 281474976710655L;	//magic number check it in binary this removes the first 16 bits
		this.current = 0;
	}
	
	public boolean hasNext(){
		return this.current < this.baseEnd;
	}
	
	/*
	 * return the next modified seed
	 */
	@SuppressWarnings("null")
	public long next(){
		if(hasNext()){
			current++;
			return (long)baseSeed ^ ((long)current << 48);
		} else
			return (Long) null;
		
	}
}
