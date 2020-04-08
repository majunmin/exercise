package com.mjm;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3FileReader;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

import java.io.File;
import java.io.IOException;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2020/3/14 4:54 下午
 * @since
 */
public class MusicAnalysis {

    public static void main(String[] args) {
        MP3FileReader mp3FileReader = new MP3FileReader();
        try {
            AudioFile autoFile = mp3FileReader.read(new File("./listenSong.flac"));
            AudioHeader audioHeader = autoFile.getAudioHeader();
            Tag tag = autoFile.getTag();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TagException e) {
            e.printStackTrace();
        } catch (ReadOnlyFileException e) {
            e.printStackTrace();
        } catch (InvalidAudioFrameException e) {
            e.printStackTrace();
        }
    }
}
