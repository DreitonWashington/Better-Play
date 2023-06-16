package com.coralsoft;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import com.coralsoft.domain.entity.Category;
import com.coralsoft.domain.entity.Video;
import com.coralsoft.domain.enums.Censure;
import com.coralsoft.domain.repository.VideoRepository;
import com.coralsoft.domain.valueObject.Image;
import com.coralsoft.domain.valueObject.Media;
import com.coralsoft.useCase.VideoUseCase;

public class VideoTests {
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(GenreTests.class);
	VideoRepository repository = new VideoUseCase();
	
	@Test
	void findAllVideos() throws Exception {
		List<Video> videos = this.repository.findAll();
		Assertions.assertNotNull(videos);
		logger.info("Videos Title-> {}", videos.stream().map(x -> x.getTitle()).collect(Collectors.toList()));
	
	}
	
	@Test
	void findByIdCategory() {
		Video video = this.repository.findById(1L);
		Assertions.assertEquals("Dungeons&Dragons", video.getTitle());
		logger.info("ID-> {}, Title-> {}, Category_id-> {}, CreatedAt-> {}", video.getId(), video.getTitle()
				, video.getCategory_id().getId(), video.getCreatedAt());
	}
	
	@Test
	void saveVideosAndDelete() {
		Video video = new Video();
		Image image = new Image();
		Media media = new Media();
		Category category_id = new Category();
		
		video.setTitle("Video title teste");
		video.setDescription("description test");
		video.setCensure(Censure.CENSURA_10);
		
		image.setFilePath("image file path test");
		video.setThumbFile(image);
		video.setBannerFile(image);
		video.setThumbHalf(image);
		
		category_id.setId(1L);
		video.setCategory_id(category_id);
		video.setYearLaunched(2023);
		video.setDuration(120);
		video.setRating(5);
		video.setPublished(true);
		
		media.setFilePath("media file path");
		video.setVideoFile(media);
		video.setTrailerFile(media);
		
		video = this.repository.save(video);
		this.repository.delete(video.getId());
		Assertions.assertEquals("Video title teste", video.getTitle());
		logger.info("Saved and Deleted ID-> {}, Name-> {}", video.getId(), video.getTitle());
	}
	
	@Test
	void updateVideo() {
		Video video = new Video();
		Video videoFromDb = new Video();
		
		video.setId(21L);
		video.setTitle("Test update title");
		video.setDescription("Test update description");
		
		videoFromDb = this.repository.update(video);
		Assertions.assertEquals(video.getTitle(), videoFromDb.getTitle());
		logger.info("Expected ID-> {}, Title-> {} Came ID-> {}, Title-> {}",video.getId(), video.getTitle(),
				videoFromDb.getId(), videoFromDb.getTitle());
		
	}

}
