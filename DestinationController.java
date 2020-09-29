package jp.co.internous.mushrooms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.mushrooms.model.domain.MstDestination;
import jp.co.internous.mushrooms.model.domain.MstUser;
import jp.co.internous.mushrooms.model.form.DestinationForm;
import jp.co.internous.mushrooms.model.mapper.MstDestinationMapper;
import jp.co.internous.mushrooms.model.mapper.MstUserMapper;
import jp.co.internous.mushrooms.model.session.LoginSession;

@Controller
@RequestMapping("/mushrooms/destination")
public class DestinationController {
	@Autowired
	private MstUserMapper userMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	private MstDestinationMapper destinationMapper;
	
	private Gson gson = new Gson();
	
//	ユーザーIDを取得する
	@RequestMapping("/")
	public String index(Model m) {
		MstUser user = userMapper.findByUserNameAndPassword(loginSession.getUserName(), loginSession.getPassword());
		
		m.addAttribute("user", user);
		m.addAttribute("loginSession", loginSession);
		return "destination";
	}
	
//	ラジオボタンにチェックされたユーザIDから宛先を論理削除（statusを1から0へ変更）
	@SuppressWarnings("unchecked")
	@RequestMapping("/delete")
	@ResponseBody
	public boolean delete(@RequestBody String destinationId) {
		
		Map<String, String> map = gson.fromJson(destinationId, Map.class);
		String id = map.get("destinationId");
		
		long result = destinationMapper.deleteDestination(Integer.parseInt(id));
		
		return result > 0;
	}
	
//	宛先登録の追加
	@RequestMapping("/register")
	@ResponseBody
	public String register(@RequestBody DestinationForm f) {
//		宛先登録
		MstDestination destination = new MstDestination(f);
		long userId = loginSession.getUserId();
		destination.setUserId(userId);
		int count = destinationMapper.addDestination(destination);
		
//		登録した宛先のID取得
		long id = 0;
		if (count > 0) {
			id = destinationMapper.findIdByUserId(userId);
		};
		return String.valueOf(id);
	}
	
}
