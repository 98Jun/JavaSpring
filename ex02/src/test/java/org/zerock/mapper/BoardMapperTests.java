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
   public void testGetList() {
   mapper.getList().forEach(board -> log.info(board));
   }
   
   
   @Test
   public void testInsert() {
      BoardVO board = new BoardVO();
      board.setTitle("고추장 닭날개 조림");
      board.setContent("근데 이제 바질을 곁들인");
      board.setWriter("newbie");
      
      mapper.insert(board);   
      
      log.info(board);
   }
   
   @Test
   public void testRead() {
      
      BoardVO board = mapper.read(5L);
      //5번 게시물 읽기
      
      log.info(board);
   }
      @Test
      public void testDelete() {
         log.info("delete count: " +mapper.delete(3L));
         }
      
      @Test
      public void testUpdate() {
         BoardVO board = new BoardVO();
         
         board.setBno(5L);
         board.setTitle("간장닭날개조림");
         board.setContent("짭조롬..");
         board.setWriter("user00");
         
         int count=mapper.update(board);
         log.info("UPDATE COUNT:"+count);
      }
         
   }
