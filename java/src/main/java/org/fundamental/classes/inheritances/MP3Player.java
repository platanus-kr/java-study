package org.fundamental.classes.inheritances;

public abstract class MP3Player implements MusicPlayer {
	@Override
	public void doPlay() { // abstract class는 interface를 반드시 implement 할 의무가 없음.
		System.out.println("implements: doPlay()");
	}
	
	private void doFastForward() {
		System.out.println("abstract: doFastForward()");
	}
	
	protected void doPreloadByNextFile() {
		System.out.println("abstract protected: doPreloadByNextFile()");
		
	}
	
	public void doReadLyrics() {
		System.out.println("abstract public: doReadLyrics()");
	}
}
