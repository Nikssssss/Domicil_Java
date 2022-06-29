package com.nsu.domicil.parser.n1;

import com.nsu.domicil.dto.DetailedAd;
import com.nsu.domicil.dto.PreviewAd;
import com.nsu.domicil.parser.common.AdDetailsBuilder;
import com.nsu.domicil.parser.common.AdDetailsMapper;
import org.jsoup.nodes.Document;

import java.util.Properties;

public class N1DetailsBuilder implements AdDetailsBuilder {
    @Override
    public DetailedAd buildDetailedAdFrom(Document document, Properties properties, PreviewAd previewAd) {
        AdDetailsMapper adDetailsMapper = new N1DetailsMapper(properties, document);
        DetailedAd detailedAd = adDetailsMapper.mapPreviewAdToDetailedAd(previewAd);
        detailedAd.setImageUrls(adDetailsMapper.mapImageUrls());
        detailedAd.setDescription(adDetailsMapper.mapDescription());
        return detailedAd;
    }
}
