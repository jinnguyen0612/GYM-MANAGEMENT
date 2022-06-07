package com.GymManager.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.GymManager.Entity.TrainingPackEntity;
import com.GymManager.Entity.TrainingPackTypeEntity;
import com.GymManager.ExtraClass.Message;
import com.GymManager.Service.TrainingPackService;
import com.GymManager.Service.TrainingPackTypeService;

@Controller
@RequestMapping("admin/package")
@Transactional
public class PackageController extends MethodAdminController {
	@Autowired
	TrainingPackTypeService trainingPackTypeService;
	@Autowired
	TrainingPackService trainingPackService;
	@Autowired
	SessionFactory factory;
	@Autowired
	HttpSession session;

	// HIá»‚N THá»Š DANH SÃ�CH GÃ“I Táº¬P
	@RequestMapping(value = "")
	public String pack(ModelMap model, Integer offset, Integer maxResult) {
		List<TrainingPackEntity> list = trainingPackService.getAllPack(offset, maxResult);
		model.addAttribute("pack", list);
		model.addAttribute("insertPackage", newPack());
		model.addAttribute("updatePackage", newPack());

		List<TrainingPackTypeEntity> listT = trainingPackTypeService.getAllPackType(offset, maxResult);
		model.addAttribute("trainingPackTypeEntity", listT);
		return "admin/package";
	}

	// HIá»‚N THá»Š LOáº I GÃ“I Táº¬P
	@RequestMapping(value = "type")
	public String packageType(ModelMap model, Integer offset, Integer maxResult) {
		List<TrainingPackTypeEntity> list = trainingPackTypeService.getAllPackType(offset, maxResult);
		model.addAttribute("packageType", list);
		model.addAttribute("updatePKT", new TrainingPackTypeEntity());
		model.addAttribute("insertPKT", newPackType());
		return "admin/package-type";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String addPackageType(ModelMap model, RedirectAttributes redirectAttributes,
			@ModelAttribute("insertPKT") TrainingPackTypeEntity trainingPackTypeEntity) {
		boolean check = trainingPackTypeService.insertPackType(trainingPackTypeEntity);
		if (check) {
			redirectAttributes.addFlashAttribute("message", new Message("success", "Thêm mới thành công !!!"));
			return "redirect:/admin/package/type.htm";
		} else {
			model.addAttribute("insertPKT", newPackType());
			model.addAttribute("message", new Message("error", "Thêm mới thất bại !!!"));
		}
		return "admin/package-type";
	}

	// Sá»¬A LOáº I GÃ“I Táº¬P
	@RequestMapping(value = "update/{packTypeID}", method = RequestMethod.GET)
	public String updatePackageType(ModelMap model, @PathVariable("packTypeID") String packIDX, Integer offset,
			Integer maxResult) {
		Session session = factory.openSession();
		TrainingPackTypeEntity trainingPackTypeEntity = (TrainingPackTypeEntity) session
				.get(TrainingPackTypeEntity.class, packIDX);
		model.addAttribute("updatePKT", trainingPackTypeEntity);
		model.addAttribute("insertPKT", newPackType());
		model.addAttribute("idModal", "modal-update");
		List<TrainingPackTypeEntity> listTKL = trainingPackTypeService.getAllPackType(offset, maxResult);
		model.addAttribute("packageType", listTKL);

		return "admin/package-type";
	}

	@RequestMapping(value = "update/{packTypeID}", method = RequestMethod.POST)
	public String updatePackageType(ModelMap model, RedirectAttributes redirectAttributes,
			@ModelAttribute("updatePKT") TrainingPackTypeEntity trainingPackTypeEntity, Integer offset,
			Integer maxResult) {
		boolean check = trainingPackTypeService.updatePackType(trainingPackTypeEntity);
		if (check) {
			redirectAttributes.addFlashAttribute("message", new Message("success", "Cập nhật thành công !!!"));
			return "redirect:/admin/package/type.htm";
		} else {
			model.addAttribute("message", new Message("success", "Cập nhật thất bại!!!"));
			List<TrainingPackTypeEntity> listTKL = trainingPackTypeService.getAllPackType(offset, maxResult);
			model.addAttribute("packageType", listTKL);
			model.addAttribute("insertPKT", newPackType());
			return "admin/package-type";
		}

	}

	// THÃŠM Má»šI GÃ“I Táº¬P
//	@RequestMapping(value="insertP", method=RequestMethod.GET)
//	public String addPackage(ModelMap model, Integer offset, Integer maxResults) {
//		List<TrainingPackTypeEntity> LIST = trainingPackTypeService.getAllPackType(offset, maxResults);
//		model.addAttribute("trainingPackTypeEntity", LIST);
//		model.addAttribute("insertP", new TrainingPackEntity());
//		return "admin/addPackage";
//	}
	@RequestMapping(value = "insertP", method = RequestMethod.POST)
	public String addPackage(ModelMap model, @ModelAttribute("insertPackage") TrainingPackEntity trainingPackEntity,
			Integer offset, Integer maxResults, RedirectAttributes redirectAttributes) {
		List<TrainingPackTypeEntity> LIST = trainingPackTypeService.getAllPackType(offset, maxResults);
		TrainingPackTypeEntity trainingPackTypeEntity = trainingPackTypeService
				.getPackByID(trainingPackEntity.getPackTypeID());

		trainingPackEntity.setTrainingPackTypeEntity(trainingPackTypeEntity);
		trainingPackService.updatePack(trainingPackEntity);
		boolean check = trainingPackService.insertPack(trainingPackEntity);
		if (check) {
			redirectAttributes.addFlashAttribute("message", new Message("success", "Thêm mới thành công !!!"));
			return "redirect:/admin/package.htm";
		} else {
			model.addAttribute("trainingPackTypeEntity", LIST);
			model.addAttribute("insertPackage", newPack());
			model.addAttribute("message", new Message("error", "Thêm mới thất bại !!!"));
			model.addAttribute("updatePackage", new TrainingPackEntity());
		}
		return "admin/package";
	}

	// Sá»¬A GÃ“I Táº¬P
	@RequestMapping(value = "updateTrainingPack/{packID}", method = RequestMethod.GET)
	public String updatePackage(ModelMap model, @PathVariable("packID") String packIDX, Integer offset,
			Integer maxResults) {
		Session session = factory.openSession();
		List<TrainingPackTypeEntity> LIST = trainingPackTypeService.getAllPackType(offset, maxResults);
		List<TrainingPackEntity> list = trainingPackService.getAllPack(offset, maxResults);
		TrainingPackEntity trainingPackEntity = (TrainingPackEntity) session.get(TrainingPackEntity.class, packIDX);
		model.addAttribute("updatePackage", trainingPackEntity);
		model.addAttribute("trainingPackTypeEntity", LIST);
		model.addAttribute("pack", list);
		model.addAttribute("idModal", "modal-update");
		model.addAttribute("insertPackage", newPack());
		return "admin/package";
	}

	@RequestMapping(value = "updateTrainingPack/{packID}", method = RequestMethod.POST)
	public String updatePackageType(ModelMap model,
			@ModelAttribute("updatePackage") TrainingPackEntity trainingPackEntity, Integer offset, Integer maxResult,
			RedirectAttributes redirectAttributes) {

		TrainingPackTypeEntity trainingPackTypeEntity = trainingPackTypeService
				.getPackByID(trainingPackEntity.getPackTypeID());
		trainingPackEntity.setTrainingPackTypeEntity(trainingPackTypeEntity);
		boolean check = trainingPackService.updatePack(trainingPackEntity);
		if (check) {
			redirectAttributes.addFlashAttribute("message", new Message("success", "Cập nhật thành công !!!"));
			return "redirect:/admin/package.htm";
		} else {
			model.addAttribute("message", new Message("error", "Cập nhật thất bại !!!"));
			List<TrainingPackEntity> listP = trainingPackService.getAllPack(offset, maxResult);
			model.addAttribute("pack", listP);
		}
		return "admin/package";
	}

	public TrainingPackTypeEntity newPackType() {
		TrainingPackTypeEntity packType = new TrainingPackTypeEntity();
		packType.setPackTypeID(this.toPK("LG", "TrainingPackTypeEntity", "packTypeID"));

		return packType;
	}

	public TrainingPackEntity newPack() {
		TrainingPackEntity pack = new TrainingPackEntity();
		pack.setPackID(this.toPK("GT", "TrainingPackEntity", "packID"));
		pack.setStatus("1");
		return pack;
	}
}
