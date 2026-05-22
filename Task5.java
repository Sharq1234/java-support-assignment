import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Task5 {

    // FIX: Use SLF4J logger instead of printStackTrace
    private static final Logger logger =
            LoggerFactory.getLogger(Task5.class);

    public ValidationResult validate(Document doc) {

        try {

            // FIX: Expected validation failure should not throw RuntimeException
            if (doc == null) {
                logger.warn("Validation failed: Document is null");

                return ValidationResult.invalid("Document is null");
            }

            String content = doc.extractContent();

            // FIX: Handle empty content as validation failure
            if (content == null || content.isEmpty()) {

                logger.warn("Validation failed: Empty content");

                return ValidationResult.invalid("Empty content");
            }

            return runValidationRules(content);

        } catch (Exception e) {

            // FIX: Replace printStackTrace with proper logging
            logger.error("Unexpected error during validation", e);

            // FIX: Never return null to avoid NullPointerException
            return ValidationResult.invalid("Validation failed");
        }
    }

    public void validateBatch(List<Document> docs) {

        for (Document doc : docs) {

            try {

                ValidationResult r = validate(doc);

                // FIX: Prevent NullPointerException before isValid()
                if (r != null && r.isValid()) {
                    saveResult(r);
                }

            } catch (Exception e) {

                // FIX: Do not silently swallow exceptions
                logger.error("Error while processing document batch", e);
            }
        }
    }

    private ValidationResult runValidationRules(String content) {
        return null;
    }

    private void saveResult(ValidationResult r) {

    }
}