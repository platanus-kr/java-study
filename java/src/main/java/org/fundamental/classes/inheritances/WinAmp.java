package org.fundamental.classes.inheritances;

public class WinAmp extends MP3Player implements MusicPlayer {
	@Override
	public void doReadLyrics() { // 필수는 아님
		super.doReadLyrics();
	}
	
	@Override
	protected void doPreloadByNextFile() { // 필수는 아님
		super.doPreloadByNextFile();
	}
	
	@Override
	public void doStop() { // 필수임
	
	}
	
	@Override
	public void doRewind() { // 필수임
	
	}
	
	// public void doPlay() ... // 이건 앞서 부모 클래스에서 구현 했기 때문에 필요 없음.
}
