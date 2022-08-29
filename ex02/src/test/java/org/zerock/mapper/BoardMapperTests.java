package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//@ContextConfiguration(classes= {org.zerock.config.RootConfig.class})
@Log4j
public class BoardMapperTests {

   @Setter(onMethod_=@Autowired)
   private BoardMapper mapper;
   
   @Test
   public void testGerList() {
      mapper.getList().forEach(board -> log.info(board));
   }
   
   @Test
   public void testInsert() {
	   BoardVO board = new BoardVO();
	   board.setTitle("엄준식 화이팅");
	   board.setContent("내용은 살아있따");
	   board.setWriter("new sunsik");
	   mapper.insert(board);

	   log.info(board);
   }
   
   @Test
   public void testInsertSelectKey() {
	   BoardVO board = new BoardVO();
	   board.setTitle("ㅅ,ㅐ로 해 select key");
	   board.setContent("새 글 , select key");
	   board.setWriter("new bie");
	   
	   mapper.insertSelectKey(board);
	   
	   log.info(board);
   }
}