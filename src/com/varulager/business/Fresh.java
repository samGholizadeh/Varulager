package com.varulager.business;

import org.joda.time.*;

public interface Fresh {
	
	public boolean isFresh(long bestBefore, DateTime date);
	public long getBestBefore();
}
