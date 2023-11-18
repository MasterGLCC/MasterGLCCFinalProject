package publication;

import org.junit.Test;
import org.junit.runner.*;

import static org.junit.Assert.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Optional;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.mock.web.MockMultipartFile;
import publication.entity.Publication;
import publication.repository.PublicationRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MainApplicationTests {

    private PublicationRepository publicationRepository;

    @Autowired
    public void setPublicationRepository(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }


    @Test
    public void addPublication() throws SQLException {
        byte[] articleBytes = "test article content".getBytes();
        byte[] codeBytes = "test article content".getBytes();
        byte[] certificatBytes = "test article content".getBytes();
        Publication publication = new Publication("Test","Publication", articleBytes, codeBytes,certificatBytes);

        publicationRepository.save(publication);
        Optional<Publication> findPublication = publicationRepository.findById(publication.getId());
        assertTrue(findPublication.isPresent());
    }

}
