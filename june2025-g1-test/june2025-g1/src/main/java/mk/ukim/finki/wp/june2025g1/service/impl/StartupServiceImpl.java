package mk.ukim.finki.wp.june2025g1.service.impl;

import mk.ukim.finki.wp.june2025g1.model.Founder;
import mk.ukim.finki.wp.june2025g1.model.Industry;
import mk.ukim.finki.wp.june2025g1.model.Startup;
import mk.ukim.finki.wp.june2025g1.model.exceptions.InvalidFounderIdException;
import mk.ukim.finki.wp.june2025g1.model.exceptions.InvalidStartupIdException;
import mk.ukim.finki.wp.june2025g1.repository.FounderRepository;
import mk.ukim.finki.wp.june2025g1.repository.StartupRepository;
import mk.ukim.finki.wp.june2025g1.service.StartupService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static mk.ukim.finki.wp.june2025g1.service.specifications.FieldFilterSpecification.*;

@Service
public class StartupServiceImpl implements StartupService {
    private final StartupRepository startupRepository;
    private final FounderRepository founderRepository;

    public StartupServiceImpl(StartupRepository startupRepository, FounderRepository founderRepository) {
        this.startupRepository = startupRepository;
        this.founderRepository = founderRepository;
    }

    @Override
    public List<Startup> listAll() {
        return startupRepository.findAll();
    }

    @Override
    public Startup findById(Long id) {
        return startupRepository.findById(id).orElseThrow(InvalidStartupIdException::new);
    }

    @Override
    public Startup create(String name, Double valuation, Integer yearFounded, Industry industry, Long founderId) {
        Founder founder = founderRepository.findById(founderId).orElseThrow(InvalidFounderIdException::new);
        return startupRepository.save(new Startup(name, valuation, yearFounded, industry, founder));
    }

    @Override
    public Startup update(Long id, String name, Double valuation, Integer yearFounded, Industry industry, Long founderId) {
        Startup startup = findById(id);
        startup.setName(name);
        startup.setValuation(valuation);
        startup.setYearFounded(yearFounded);
        startup.setIndustry(industry);
        Founder founder = founderRepository.findById(founderId).orElseThrow(InvalidFounderIdException::new);
        startup.setFounder(founder);
        return startupRepository.save(startup);
    }

    @Override
    public Startup delete(Long id) {
        Startup startup = findById(id);
        startupRepository.delete(startup);
        return startup;
    }

    @Override
    public Startup deactivate(Long id) {
        Startup startup = findById(id);
        startup.setActive(false);
        return startupRepository.save(startup);
    }

    @Override
    public Page<Startup> findPage(String name, Double valuation, Integer yearFounded, Industry industry, Long founderId, int pageNum, int pageSize) {
        Specification<Startup> specification = Specification.allOf(
                filterContainsText(Startup.class, "name", name),
                greaterThan( Startup.class, "valuation", valuation),
                greaterThan( Startup.class, "yearFounded", yearFounded),
                filterEqualsV(Startup.class, "industry", industry),
                filterEquals(Startup.class, "founder.id",founderId)
        );

        return this.startupRepository.findAll(
                specification,
                PageRequest.of(pageNum, pageSize));
    }
}
